package calculator;

public class InputString {
    private final String input;

    public InputString(String input) {
        this.input = input.trim();
    }

    public boolean isEmpty() {
        return input.isEmpty();
    }

    public String getRawInput() {
        return input;
    }

}