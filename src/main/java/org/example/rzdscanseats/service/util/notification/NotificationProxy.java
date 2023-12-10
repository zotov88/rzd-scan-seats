package org.example.rzdscanseats.service.util.notification;


import org.example.rzdscanseats.model.User;

public interface NotificationProxy {

    void send(User user, String message);

    void sendToAdmin(String message);
}
