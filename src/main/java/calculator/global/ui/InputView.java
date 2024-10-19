package calculator.global.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final String BASIC_DELIMITER = "[,;]";
    private final String CUSTOM_DELIMITER = "//(.*)\\\\n(.*)";

    public String inputString() {
        return Console.readLine();
    }

    private String[] splitDelimiterNumbers(String input) {

        String delimiter = BASIC_DELIMITER;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(delimiter);
    }

    public int[] parseIntNumbers(String input) {

        String[] stringNumbers = splitDelimiterNumbers(input);
        int[] numbers = new int[stringNumbers.length];

        try {
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
                checkNegativeNumber(numbers[i]);
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
