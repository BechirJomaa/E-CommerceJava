/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Mail;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author FADI
 */
public class SendEmail {
  
    
public void send2(Mail mail) {

    
    
    


final String username = mail.getMail();
 final String password = mail.getPassword();

    Properties props = new Properties();
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.auth", true);   
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication( username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        //mail ds interface 
        message.setFrom(new InternetAddress(mail.getMail()));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("maher.gafsi@esprit"));//@ verslaquelle envoer mail 
        message.setSubject(mail.getSubject());    
        message.setText("Pi");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart.setText(mail.getContenu());
        multipart.addBodyPart(messageBodyPart);


    
    
        message.setContent(multipart);

       
        System.out.println("sending");
        Transport.send(message);
        System.out.println("Done");
        
        //attacher un fichier ( 2eme bodypart)----------------------
        String file = "path of file";
        String fileName = "AnyName1";
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
    //----------------------------------------------------------
        
   

            
}catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
