package org.example.rzdscanseats.service.util.notification;

import lombok.RequiredArgsConstructor;
import org.example.rzdscanseats.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public final class SenderNotifications {

    private final List<NotificationProxy> notifiers;

    public void sendAll(User user, String message) {
        for (NotificationProxy notifier : notifiers) {
            notifier.sendMessage(user, message);
        }
    }
}
