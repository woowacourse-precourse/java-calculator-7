package calculator.ui;

import calculator.service.UserInputSeparator;

public class UserInputMessage {

    private final String message;

    public UserInputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public UserInputSeparator getUserInputSeparator() {
        return UserInputSeparator.of(this.message);
    }
}
