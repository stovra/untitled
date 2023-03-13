package org.example;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public interface Mime{
      default void readEmails(String email, String password, String host, String userSubject) throws MessagingException {
            Map<String, String> map = new HashMap<>();
            Properties props = new Properties();
            props.setProperty("mail.imap.host", host);
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
            System.out.println(map.get(userSubject.toLowerCase()));
      }
      String getTextFromMimeMultipart(MimeMultipart multipart) throws MessagingException, IOException;
}
