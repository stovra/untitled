package org.example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args) throws MessagingException {
        Config conf = ConfigFactory.load("myconfig.conf");
        String mail1 = conf.getString("gmail.mail");
        String password1= conf.getString("gmail.password");
        String mail2= conf.getString("hotmail.mail");
        String password2= conf.getString("hotmail.password");

       if (mail1.contains("hotmail") || mail1.contains("outlook")){
            Hotmail hotmail=new Hotmail(mail1, password1);
            hotmail.readEmails();
        } else if (mail1.contains("gmail")){
            Gmail gmail=new Gmail(mail1, password1);
            gmail.readEmails();
        } else {
            System.out.println("Wrong email");
        }

        /*
        if (mail2.contains("hotmail") || mail2.contains("outlook")){
            Hotmail hotmail=new Hotmail(mail2, password2);
            hotmail.readEmails();
        } else if (mail2.contains("gmail")) {
            Gmail gmail=new Gmail(mail2, password2);
            gmail.readEmails();
        } else {
            System.out.println("Wrong email");
        }
       */

    }
}