package calculator.input;


public class InputReader {

    private final String input;

    public InputReader(String input) {
        InputValidator.validateInputBlank(input);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
