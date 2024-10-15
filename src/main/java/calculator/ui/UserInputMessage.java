package calculator.ui;

public class UserInputMessage {

    private final String message;

    public UserInputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
