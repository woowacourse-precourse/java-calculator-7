package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        // 입력값이 빈 문자열이거나 null인 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        // 구분자 추출 및 문자열 분리
        String[] delimiterAndNumbers = getDelimiter(input);
        String delimiter = delimiterAndNumbers[0];
        String numbers = delimiterAndNumbers[1];

        // 숫자 합산
        return calculateSum(numbers, delimiter);
    }

    private String[] getDelimiter(String input) {
        String defaultDelimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                String remainString = matcher.group(2);

                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
                }

                // 커스텀 구분자를 사용하여 문자열을 분리할 수 있도록 반환
                return new String[]{Pattern.quote(customDelimiter), remainString};
            } else {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
        }

        return new String[]{defaultDelimiter, input};
    }

    private int calculateSum(String input, String delimiter) {
        String[] numbers = input.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            // 문자열에 포함된 공백 제거
            number = number.trim();

            if (number.isEmpty()) {
                continue;
            }

            int num;
            try {
                num = Integer.parseInt(number);
                // 음수 예외 처리
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 숫자입니다.");
            }

            sum += num;
        }

        return sum;
    }
}
