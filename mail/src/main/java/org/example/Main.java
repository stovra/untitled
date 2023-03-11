

package org.example;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MessagingException {
        Map <String, String> map= new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email");
        String email = scan.nextLine();
        System.out.println("Enter your password");
        String password = scan.nextLine();
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
        String subject="";
        String text="";
        for (Message message : messages) {
            subject = message.getSubject().toLowerCase();
            try {

                Object content = message.getContent();
                if (content instanceof String) {
                    text = (String) content;
                } else if (content instanceof MimeMultipart) {
                    MimeMultipart multipart = (MimeMultipart) content;
                    text = getTextFromMimeMultipart(multipart);
                }

                map.put(subject, text);
            } catch (IOException | MessagingException e) {
                throw new RuntimeException(e);
            }
        }
        inbox.close(false);
        store.close();
        System.out.println("Search your inbox, enter subject");
        String userSubject= scan.nextLine().toLowerCase();
        System.out.println(map.get(userSubject));
    }
    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
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



