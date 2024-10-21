package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        return calculateSum(numbers);
    }

    private static String[] splitInput(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자입니다.");
            }
        }
        return input.split(delimiter);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number);
        }
        return sum;
    }

    private static int parseNumber(String number) {
        int num;
        try {
            num = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
        }

        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
        }
        return num;
    }
}
