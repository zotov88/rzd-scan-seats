package org.example.rzdscanseats.service.util.notification;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.example.rzdscanseats.model.User;
import org.springframework.stereotype.Component;

@Component
public class TelegramNotificationProxy implements NotificationProxy {

    @Override
    public void send(User user, String message) {
        TelegramBot bot = new TelegramBot(user.getTgBotToken());
        bot.execute(new SendMessage(user.getTgChatId(), message));
    }

}
