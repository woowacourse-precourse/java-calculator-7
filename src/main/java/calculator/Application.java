package calculator;

import camp.nextstep.edu.missionutils.Console;

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

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int calculateSum(String input) {
        int sum = 0;
        String[] numbers = splitNumberString(input);

        for (String token : numbers) {
            int number = parseNumber(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = calculateSum(input);
        System.out.println("결과 : " + result);
    }
}
