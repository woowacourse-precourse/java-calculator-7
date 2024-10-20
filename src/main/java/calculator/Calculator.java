package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITER = "[,:]"; // 기본 구분자
    private static final String CUSTOM_DELIMITER_REGEX = "//(.*?)\\n(.*)"; // 커스텀 구분자 정규식
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX, Pattern.DOTALL);

    public static int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0; // 빈 문자열인 경우 0 반환
        }

        String delimiter = DEFAULT_DELIMITER; // 기본 구분자를 사용
        String numbers = input; // 입력 숫자 초기화

        // 입력 문자열에서 \\n을 실제 개행 문자로 변환
        input = input.replace("\\n", "\n");

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
            if (matcher.find()) {
                delimiter = Matcher.quoteReplacement(matcher.group(1)); // 구분자 업데이트
                numbers = matcher.group(2).trim(); // 숫자 부분 설정
            } else {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다."); // 잘못된 형식 예외 처리
            }
        }

        // 숫자 계산 및 반환
        return calculateSum(numbers.split(delimiter)); // 변경된 delimiter를 배열로 분리
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int calculateSum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (trimmedToken.isEmpty()) {
                continue; // 빈 문자열 무시
            }
            sum += parseAndValidateNumber(trimmedToken);
        }

        return sum;
    }

    private static int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다."); // 음수 예외 처리
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다."); // 숫자 형식 예외 처리
        }
    }
}
