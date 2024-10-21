package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 기본 구분자: 쉼표와 콜론
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 커스텀 구분자를 처리하는 정규식, \n이 문자 그대로 들어온 경우 처리
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 처리
        }

        // 커스텀 구분자 처리
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.find()) {  // 커스텀 구분자와 숫자 부분을 찾으면
            String customDelimiter = matcher.group(1);  // 커스텀 구분자 추출
            String numbers = matcher.group(2);  // 숫자 부분 추출
            return calculateSum(numbers, Pattern.quote(customDelimiter));  // 커스텀 구분자로 숫자 계산
        }

        // 기본 구분자(쉼표, 콜론) 처리
        return calculateSum(input, DEFAULT_DELIMITERS);
    }

    private static int calculateSum(String input, String delimiter) {
        String[] tokens = input.split(delimiter);  // 구분자로 문자열을 나눔
        int sum = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {  // 빈 문자열 무시
                int number = parseNumber(token.trim());  // 공백 제거 후 숫자로 변환
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
                sum += number;
            }
        }
        return sum;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);  // 문자열을 숫자로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값: " + token);  // 변환 실패 시 예외 처리
        }
    }
}