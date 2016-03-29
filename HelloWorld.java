import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.LogicalOperator;
import microsoft.exchange.webservices.data.core.enumeration.service.ConflictResolutionMode;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.EmailMessageSchema;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.Attachment;
import microsoft.exchange.webservices.data.property.complex.AttachmentCollection;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.FileAttachment;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.Scanner;

public class HelloWorld{

     public static void main(String []args) throws Exception{
    
        	
        ExchangeService service=new ExchangeService();
        Scanner s=new Scanner(System.in);
        System.out.print("server host: ");
        String server=s.next();

	    System.out.print("domain: ");
        String domain=s.next();
        
        System.out.print("user: ");
        String user=s.next();
	    
	    System.out.print("pass: ");
	    String pass=s.next();
	    
        
        System.out.print("from: ");
        String from=s.next();
        
        System.out.print("to: ");
        String to=s.next();
    
        service.setCredentials(new WebCredentials(user,pass ,domain));
        	
        URI uri=new URI("https://" + server + "/ews/exchange.asmx");
        	
        service.setUrl(uri);
        	
        EmailMessage replymessage = new EmailMessage(service);
        EmailAddress fromEmailAddress = new EmailAddress(from);
        replymessage.setFrom(fromEmailAddress);
        replymessage.getToRecipients().add(to);
        replymessage.setSubject("subject");
        replymessage.setBody(new MessageBody("body"));
        replymessage.send();
    	service.close();
 }
}
