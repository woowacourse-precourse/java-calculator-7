package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String input) {

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher customDelimiterMatcher = Pattern.compile("//(\\[.*?\\])\n(.*)").matcher(input);
            if (customDelimiterMatcher.matches()) {
                delimiter = customDelimiterMatcher.group(1).replaceAll("[\\[\\]]", "");  // 여러 문자 구분자 처리
                numbers = customDelimiterMatcher.group(2);
            } else {
                Matcher singleDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(input);
                if (singleDelimiterMatcher.matches()) {
                    delimiter = Pattern.quote(singleDelimiterMatcher.group(1));  // 단일 문자 구분자 처리
                    numbers = singleDelimiterMatcher.group(2);
                } else {
                    throw new IllegalArgumentException("잘못된 형식입니다.");
                }
            }
        }

        // 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiter);

        // 음수 값 체크
        String negativeNumbers = Arrays.stream(tokens)
                .filter(token -> Integer.parseInt(token) < 0)
                .collect(Collectors.joining(", "));

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negativeNumbers);
        }

        try {
            // 숫자 변환 및 합산 수행
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }
}
