package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(input);
        return sum(numbers);
    }

    // private String[] splitNumbers(String input) {
    //     Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
    //     if (matcher.find()) {
    //         String customDelimiter = Pattern.quote(matcher.group(1));
    //         String numbersString = matcher.group(2);
    //         return numbersString.split(customDelimiter);
    //     }
    //     return input.split(DEFAULT_DELIMITER);
    // }

    private String[] splitNumbers(String input) {
        // '\\n'을 실제 '\n'으로 변환
        input = input.replace("\\n", "\n");
        
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));  // 커스텀 구분자 추출
            String numbersString = matcher.group(2);  // 숫자 문자열
            return numbersString.split(customDelimiter + "|,|:");  // 커스텀 구분자와 기본 구분자로 분리
        }
        return input.split(DEFAULT_DELIMITER);  // 기본 구분자로 분리
    }
    
    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private int parseNumber(String number) {
        try {
            int value = Integer.parseInt(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }
    }
}