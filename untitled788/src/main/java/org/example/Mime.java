package org.example;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

public interface Mime{

      String getTextFromMimeMultipart(MimeMultipart multipart) throws MessagingException, IOException;
}
