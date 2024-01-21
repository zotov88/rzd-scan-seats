package org.example.rzdscanseats.service.util.mailutil;

import lombok.experimental.UtilityClass;
import org.springframework.mail.SimpleMailMessage;

@UtilityClass
public class MailUtil {

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