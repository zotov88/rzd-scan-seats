package org.example.rzdscanseats.service.util.notification;


import org.example.rzdscanseats.model.User;

public interface NotificationProxy {

    void sendMessage(User user, String message);
}
