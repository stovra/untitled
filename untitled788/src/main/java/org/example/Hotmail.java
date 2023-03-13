package org.example;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

public class Hotmail implements Mime {
    private String email;
    private String password;


    public Hotmail(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public   String getTextFromMimeMultipart(MimeMultipart multipart) throws MessagingException, IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (bodyPart.getContentType().startsWith("text/plain")) {
                sb.append((String) bodyPart.getContent());
            }
        }
        return sb.toString();
    }
}


