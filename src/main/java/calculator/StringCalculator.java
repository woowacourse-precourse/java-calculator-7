package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n";

    String userInput = Console.readLine();

    public static String findCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String[] splitString(String input, String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            return input.split(DELIMITERS);
        }
        return input.substring(customDelimiter.length() + 3).split(customDelimiter);
    }

    public static int sumNumbers(String[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += Integer.parseInt(numbers[i]);
        }
        return result;
    }
}
