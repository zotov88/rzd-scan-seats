package org.example.rzdscanseats.service.util.notification;

import org.example.rzdscanseats.entity.User;

public interface NotificationProxy {

    void sendMessage(User user, String message);
}
