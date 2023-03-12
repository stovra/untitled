package org.example;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Gmail implements Mime {
    private String email;
    private String password;
    private Scanner sc = new Scanner(System.in);


    public Gmail(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public void readEmails() throws MessagingException {
        Map<String, String> map = new HashMap<>();
        Properties props = new Properties();
        props.setProperty("mail.imap.host", "imap.gmail.com");
        props.setProperty("mail.imap.port", "993");
        props.setProperty("mail.imap.ssl.enable", "true");
        props.put("mail.imap.starttls.required", "true");
        props.put("mail.imap.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Store store = session.getStore("imap");
        store.connect();
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message[] messages = inbox.getMessages();
        String subject = "";
        String text = "";
        for (Message message : messages) {
            System.out.println(message.getSubject());
            subject = message.getSubject().toLowerCase();
            try {
                Object content = message.getContent();
                if (content instanceof String) {
                    text = (String) content;
                } else if (content instanceof MimeMultipart) {
                    MimeMultipart multipart = (MimeMultipart) content;
                    text = getTextFromMimeMultipart(multipart);
                    System.out.println(text);
                }

                map.put(subject, text);
            } catch (IOException | MessagingException e) {
                throw new RuntimeException(e);
            }
        }
        inbox.close(false);
        store.close();
        System.out.println("Enter subject");
        String userSubject= sc.nextLine().toLowerCase();
        System.out.println(map.get(userSubject));
    }

    public String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            Object content = bodyPart.getContent();
            if (bodyPart.isMimeType("text/plain")) {
                sb.append((String) content);
            } else if (content instanceof MimeMultipart) {
                sb.append(getTextFromMimeMultipart((MimeMultipart) content));
            }
        }
        return sb.toString();
    }
}
