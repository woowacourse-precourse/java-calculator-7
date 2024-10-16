package calculator.service.util;

public final class InputParser {
    private static String[] splitByDelimiters(String input, String delimiters) {
        return input.split(delimiters);
    }
}