package calculator.domain.error;

import calculator.domain.message.MessageProvider;

public class InputException extends IllegalArgumentException {
    private InputException(MessageProvider messageProvider) {
        super(messageProvider.getMessage());
    }

    public static InputException from(MessageProvider messageProvider) {
        return new InputException(messageProvider);
    }
}
