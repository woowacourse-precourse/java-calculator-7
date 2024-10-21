package calculator.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageSource {

    private final ResourceBundle messages;

    public MessageSource(Locale locale) {
        this.messages = ResourceBundle.getBundle("messages", locale);
    }

    public String getMessage(String code) {
        return messages.getString(code);
    }

    public String getMessage(String code, Object... args) {
        String message = messages.getString(code);
        return String.format(message, args);
    }
}
