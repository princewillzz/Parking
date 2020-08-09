package xyz.willz.features;import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

    public void sendMail() {
    	try {
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("princewillz2013@gmail.com"));
        message.setRecipient(RecipientType.TO, new InternetAddress("harshtiwariai@gmail.com"));
        message.setSubject("Notification");
        message.setText("Successful!", "UTF-8"); // as "text/plain"
        message.setSentDate(new Date());
        Transport.send(message);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }

}