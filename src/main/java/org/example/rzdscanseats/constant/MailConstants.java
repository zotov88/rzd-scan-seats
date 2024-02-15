package org.example.rzdscanseats.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MailConstants {

    public String MAIL_SUBJECT_FOR_REMEMBER_PASSWORD = "Восстановление пароля";

    public String MAIL_MESSAGE_FOR_REMEMBER_PASSWORD = """
            Добрый день.
            Для восстановления пароля перейдите по ссылке:
            http://localhost:8080/users/change-password?uuid=
            """;
}
