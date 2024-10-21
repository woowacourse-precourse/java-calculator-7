package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private String DELIMITERS = ",|:"; // 기본 구분자 (쉼표, 콜론)
    private String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)"; // 커스텀 구분자 형식

    public String[] validateInput(String input) {
        // 빈 문자열의 경우 빈 문자열 반환
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        // 정해진 형식대로 생겼는지 확인
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        String delimiter = DELIMITERS;
        boolean matches = Pattern.matches(CUSTOM_DELIMITER_REGEX, input);
        // 커스텀 구분자가 있는 경우
        if (matcher.matches() || matches) {
            delimiter = delimiter + "|" + matcher.group(1); // 커스텀 구분자 추출
            DELIMITERS = delimiter;
            String numbers = matcher.group(2); // 숫자 부분 추출
            return numbers.split(DELIMITERS);
        }

        return input.split(DELIMITERS);
    }

    public int validatePositiveNum(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 허용됩니다: " + value);
        }

        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return number;
    }
}
