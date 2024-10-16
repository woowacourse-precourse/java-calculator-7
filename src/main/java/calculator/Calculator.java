package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_DELIMITER_INPUT_INDEX = 5;

    private static String input;
    private static String delimiters;
    private static String[] numbers;

    public static void run(String inputValue) {
        setInput(inputValue);
        setDelimiter();
        validateInput();
        parseInput();
        validateNumbers();
    }

    private static void setInput(String inputValue) {
        input = inputValue;
    }

    private static void setDelimiter() {
        if (input.startsWith("//") && input.startsWith("\\n", CUSTOM_DELIMITER_END_INDEX)) {
            delimiters = "[,:" + input.charAt(CUSTOM_DELIMITER_INDEX) + "]";
            input = input.substring(CUSTOM_DELIMITER_INPUT_INDEX);
            return;
        }
        delimiters = "[,:]";
    }

    private static void validateInput() {
        String regex = "^[0-9" + delimiters + "]*$";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("허용되지 않은 문자가 포함되어 있습니다.");
        }
    }

    private static void parseInput() {
        numbers = input.split(delimiters);
    }

    private static void validateNumbers() {
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("구분자 사이에 숫자가 존재하지 않습니다.");
            }
        }
    }
}
