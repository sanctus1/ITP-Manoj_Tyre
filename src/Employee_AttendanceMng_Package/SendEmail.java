/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee_AttendanceMng_Package;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JComboBox;
/**
 *
 * @author Manju_PC
 */
public class SendEmail {
    
    
public void send2() {

    final String username = "manojtyre.center@gmail.com"; //ur email
    final String password = "ganemulla@manojtyre";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("manojtyre.center@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("teshanrock@gmail.com"));//u will send to
        message.setSubject("Leave Requests Replay");    
        message.setText("PFA");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();


     
     
    //attached 1 --------------------------------------------
    Emp_mng_Admin admin = new Emp_mng_Admin();
    String path = admin.FilePath;
    JComboBox selectCombo = admin.accept_Not_Req;
    //String Selection = (String) selectCombo.getSelectedItem();
    
//    if(Selection.equals("Accept")){
    
        String file ="C:\\Users\\Manju_PC\\Desktop\\teshan.txt";
        String fileName = "Approval.txt";
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
    //------------------------------------------------------    
//    }
//    else if(Selection.equals("Not Accept")){
//    
//        String file = path ;//"C:\\Users\\Manju_PC\\Desktop\\teshan.txt"
//        String fileName = "Can't Approval.txt";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source = new FileDataSource(file);      
//    messageBodyPart.setDataHandler(new DataHandler(source));
//    messageBodyPart.setFileName(fileName);
//    multipart.addBodyPart(messageBodyPart);
//    //------------------------------------------------------   
//    }
//    else{
//        System.out.println("NO selecttion");
//        
//    }
        message.setContent(multipart);

       
        System.out.println("sending");
        Transport.send(message);
        System.out.println("Done");
        
   

            
}catch (MessagingException e) {
        e.printStackTrace();
    }
  }
    
    
}
