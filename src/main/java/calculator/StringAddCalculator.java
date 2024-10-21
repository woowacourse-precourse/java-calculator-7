package calculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            return splitAndSumWithCustomDelimiter(input);
        }
        return splitAndSumWithDefaultDelimiter(input);
    }

    private static int splitAndSumWithDefaultDelimiter(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITERS);
        return calculateSum(tokens);
    }

    private static int splitAndSumWithCustomDelimiter(String input) {
        // \\n 이스케이프 처리를 위해 더블 백슬래시 사용
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);

        String[] tokens = numbers.split(Pattern.quote(customDelimiter));
        return calculateSum(tokens);
    }


    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = toPositiveInt(number);
            sum += num;
        }
        return sum;
    }

    private static int toPositiveInt(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return num;
    }
}

