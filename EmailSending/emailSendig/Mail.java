package emailSendig;

/*
 * @JahirBasha
 * 04/08/2021
*/

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	
	public static void sendmail( String recipient) throws Exception {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		//Enter your mail and password here from which to send
		String MyAccountEmail = "YourMail";
		String password = "Your Password";
		
		Session session = Session.getInstance(properties,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MyAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session,MyAccountEmail,recipient);
		
	Transport.send(message);
		System.out.println("Message sent");
		
	}
	
	

private static Message prepareMessage(Session session, String MyAccountEmail, String recepient) {
		
		Message message = new MimeMessage(session);
		
			try {
				message.setFrom(new InternetAddress(MyAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				message.setSubject("My Email App");
				
				String[] splittedArray = recepient.split("@");
				String name = splittedArray[0];
				System.out.println(name);
				
				message.setText("Dear " +name+",\n Welcome to my bulk email application");
				
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}	
		return message;
	}
	public void process(String string) {
	
		prepareMessage(null, string, string);
		
	}
	
	
}
