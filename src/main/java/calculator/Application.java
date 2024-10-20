package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String[] extractCustomDelimiterNumbers(String input) {
        String[] custom_delimiter_numbers = new String[2];

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            custom_delimiter_numbers[0] = Pattern.quote(matcher.group(1));
            custom_delimiter_numbers[1] = matcher.group(2);
        }
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return custom_delimiter_numbers;
    }

    private static String[] addCustomDelimiter(String input, String delimiter) {
        String[] custom_delimiter_numbers = extractCustomDelimiterNumbers(input);
        custom_delimiter_numbers[0] = String.join("|", delimiter, custom_delimiter_numbers[0]);
        return custom_delimiter_numbers;
    }

    private static String[] splitNumberString(String input) {
        boolean is_custom_delimiter;
        String numbers = input;
        String delimiter = String.join("|", ",", ":");

        is_custom_delimiter = hasCustomDelimiter(input);
        if (is_custom_delimiter) {
            String[] custom_delimiter_numbers = addCustomDelimiter(input, delimiter);
            delimiter = custom_delimiter_numbers[0];
            numbers = custom_delimiter_numbers[1];
        }
        return numbers.split(delimiter);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
