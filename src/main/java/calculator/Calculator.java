package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.replace("\\n", "\n"); // 이스케이프 문자열을 실제 줄바꿈으로 변환

        String[] numbers;

        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
                String numbersPart = matcher.group(2);
                numbers = numbersPart.split(Pattern.quote(customDelimiter) + "|,|:");
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        } else {
            String delimiters = ",|:";
            numbers = input.split(delimiters);
        }

        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            sum += num;
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }
}
