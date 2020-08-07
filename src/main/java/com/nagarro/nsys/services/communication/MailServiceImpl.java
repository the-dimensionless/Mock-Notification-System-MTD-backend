package com.nagarro.nsys.services.communication;

import java.io.File;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.google.common.io.Files;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
    private JavaMailSender sender;
	
	private void sendEmailActual(List<String> mails, String subject, String msg) throws Exception {
		
		 MimeMessage message = sender.createMimeMessage();
		 
		 message.setRecipients(Message.RecipientType.TO,
				mails.stream().map(i->{
					try {
						return new InternetAddress(i);
					} catch (AddressException e) {
						e.printStackTrace();
						return null;
					}
				}).collect(Collectors.toList()).toArray(new Address[0]));
		 
		 formatMessage(message, msg);
		 
	        sender.send(message);
	        System.out.println("Successfully Sent mail to all");
	}
	
	/**
	 * Formats the message by adding a Content CID for Image
	 * @param message
	 * @param msg
	 */
	 private void formatMessage(MimeMessage message, String msg) {
		 try {
			 
		 int startIndex = msg.indexOf("base64,")+"base64,".length();
		 int endIndex = msg.indexOf("\">", startIndex);
		 
		 String sub = msg.substring(startIndex, endIndex);
		 
		 String renewed = msg.substring(0, startIndex-"data:image/jpeg;base64,".length()) 
				 + "cid:AbcXyz123"
				 + msg.substring(endIndex);
		 
		 MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(renewed, "text/html");
	        
		 Multipart multipart = new MimeMultipart();
		 multipart.addBodyPart(messageBodyPart);
		
		 MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.setHeader("Content-ID", "AbcXyz123");
		imagePart.setDisposition(MimeBodyPart.INLINE);
		
		File f = new File("abc.png");
		Files.write(Base64.getDecoder().decode(sub), f);
		
		imagePart.attachFile(f);
		multipart.addBodyPart(imagePart);
		message.setContent(multipart);
		
		 } catch(Exception e) {
			 System.out.println(e);
		 }
	}

	public void sendEmail(List<String> mails, String subject, String msg) throws Exception{
	       this.sendEmailActual(mails, subject, msg);
	    }    
}
