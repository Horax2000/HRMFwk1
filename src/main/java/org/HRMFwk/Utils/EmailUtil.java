package org.HRMFwk.Utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String to, String subject, String body, String attachmentPath) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@example.com", "your_password");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_email@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(body);

            if (attachmentPath != null) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(attachmentPath);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);
                multipart.addBodyPart(attachmentPart);
                message.setContent(multipart);
            } else {
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);
                message.setContent(multipart);
            }

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}