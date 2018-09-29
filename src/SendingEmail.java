
import java.util.Properties;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {

    private String subject;
    private String body;
    private String recevierAddress;
    private Mail mail;


    public void sendMail(Mail mail){
        this.subject = mail.getSubject();
        this.body = mail.getBody();
        this.recevierAddress = mail.getReceiverAddress();

        final String username = "nimalpereracs@gmail.com";
        final String password = "cse@1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nimalpereracs@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.recevierAddress));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
