package org.example.rzdscanseats.service.util.notification;

import org.example.rzdscanseats.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class SenderNotifications {

    private final List<NotificationProxy> notifiers;

    public SenderNotifications(List<NotificationProxy> notifiers) {
        this.notifiers = notifiers;
    }

    public void sendAll(User user, String message) {
        for (NotificationProxy notifier : notifiers) {
            notifier.send(user, message);
        }
    }
}
