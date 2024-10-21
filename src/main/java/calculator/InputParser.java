package calculator;

public class InputParser {
    private String parsedinput;
    public InputParser(String input) {
        parsedinput = parseInput(input);
    }
    private String parseInput(String input) {
        input = input.substring(5);
        if(input.isEmpty()) return "0";
        return input;
    }

    public String getParsedInput() {
        return parsedinput;
    }
}
