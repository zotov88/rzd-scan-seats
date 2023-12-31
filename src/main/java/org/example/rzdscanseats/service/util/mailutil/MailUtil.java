package org.example.rzdscanseats.service.util.mailutil;

import org.springframework.mail.SimpleMailMessage;

public class MailUtil {

    private MailUtil() {}

    public static SimpleMailMessage createMailMessage(final String email, 
                                                      final String subject,
                                                      final String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        return message;
        
    }
}