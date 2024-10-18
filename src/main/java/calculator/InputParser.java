package calculator;

public class InputParser {
    private String input;
    public InputParser(String input) {
        this.input = input;
        parseInput();
    }
    private void parseInput() {
        input = input.substring(5);
    }

    public String getparsedInput() {
        return input;
    }
}
