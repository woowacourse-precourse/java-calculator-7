package calculator;

public class InputParser {
    private String parsedinput;

    public InputParser(String input) {
        parsedinput = parseInput(input);
    }

    private String parseInput(String input) {
        return input.substring(5);
    }

    public String getParsedInput() {
        return parsedinput;
    }
}
