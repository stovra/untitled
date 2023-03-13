package org.example;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

public class Gmail implements Mime {
    private String email;
    private String password;

    public Gmail(String email, String password) {
        this.email = email;
        this.password = password;

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
