package calculator;

public abstract class InputValidator {

    protected String input;
    protected String delimiter;

    public InputValidator(String input, String delimiter) {
        this.input = input;
        this.delimiter = delimiter;
    }

    abstract boolean isValidInput();
}