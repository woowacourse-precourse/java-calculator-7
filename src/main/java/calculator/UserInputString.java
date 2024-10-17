package calculator;

public class UserInputString {
    private final String input;

    public UserInputString(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public boolean isInputEmpty() {
        return input.isEmpty();
    }
}
