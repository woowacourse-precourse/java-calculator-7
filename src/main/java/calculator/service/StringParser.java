package calculator.service;

public class StringParser {
    public String[] parseString(String input) {
        String[] parsed = input.split(", | :");
        return parsed;
    }
}
