package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final static String customDelimiterPrefix = "//";
    private final static String customDelimiterSuffix = "\\n";

    private static List<Character> delimiters;


    public static List<Integer> parse(String input) {
        delimiters = new ArrayList<>(List.of(':', ','));
        List<Integer> numbers = new ArrayList<>();

        input = parseCustomDelimiter(input);

        String[] stringNumbers = input.split(delimiters.toString());

        for (String stringNumber : stringNumbers) {
            checkNumeric(stringNumber);

            int number = Integer.parseInt(stringNumber);
            numbers.add(number);
        }

        return numbers;
    }

    private static String parseCustomDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            delimiters.add(input.charAt(2));
            return input.substring(5);
        }
        return input;
    }

    private static boolean isCustomDelimiter(String input) {
        if (input.charAt(0) != '/') {
            return false;
        }
        if (input.length() < 5) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private static void checkNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
