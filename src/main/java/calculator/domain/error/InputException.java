package calculator.domain.error;

import calculator.domain.message.MessageProvider;

public class InputException extends IllegalArgumentException {
    public InputException(MessageProvider messageProvider) {
        super(messageProvider.getMessage());
    }
}
