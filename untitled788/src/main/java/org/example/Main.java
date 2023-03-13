package org.example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args) throws MessagingException {
        Config conf = ConfigFactory.load("myconfig.conf");
        String mail1 = conf.getString("gmail.mail");
        String password1= conf.getString("gmail.password");
        String host1= conf.getString("gmail.host");
        String subject1= conf.getString("gmail.subject");

        String mail2= conf.getString("hotmail.mail");
        String password2= conf.getString("hotmail.password");
        String host2= conf.getString("hotmail.host");
        String subject2= conf.getString("hotmail.subject");

        if (mail1.contains("hotmail") || mail1.contains("outlook")){
            Mime hotmail = new Hotmail(mail1, password1);
            hotmail.readEmails(mail1, password1,host1, subject1);
        } else if (mail1.contains("gmail")){
            Mime gmail = new Gmail(mail1, password1);
            gmail.readEmails(mail1, password1,host1, subject1);
        } else {
            System.out.println("Wrong email");
        }

        /*
        if (mail2.contains("hotmail") || mail2.contains("outlook")){
            Mime hotmail = new Hotmail(mail2, password2);
            hotmail.readEmails(mail2, password2,host2, subject2);
        } else if (mail2.contains("gmail")) {
            Mime gmail=new Gmail(mail2, password2);
            gmail.readEmails(mail2, password2,host2, subject2);
        } else {
            System.out.println("Wrong email");
        }
       */

    }
}