package calculator.error;

import calculator.message.MessageProvider;

public class CustomException extends IllegalArgumentException {
    private CustomException(MessageProvider messageProvider) {
        super(messageProvider.getMessage());
    }

    public static CustomException from(MessageProvider messageProvider) {
        return new CustomException(messageProvider);
    }
}
