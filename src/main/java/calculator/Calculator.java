package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열은 0을 반환
        }

        String[] numbers = splitNumbers(input);
        return calculateSum(numbers);
    }

    private String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                return matcher.group(2).split(Pattern.quote(customDelimiter));
            }
            throw new IllegalArgumentException("잘못된 구분자 포맷입니다.");
        }
        return input.split(",|:");  // 기본 구분자 (쉼표, 콜론)
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
