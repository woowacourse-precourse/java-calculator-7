package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    // 기본 구분자는 쉼표와 콜론
    private static final String DEFAULT_DELIMITERS = "[,:]";
    // 커스텀 구분자를 정의하는 패턴
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0; // 입력이 비어있으면 0을 반환
        }

        String[] parts = extractDelimiters(input);
        String delimiter = parts[0]; // 구분자 추출
        String numbers = parts[1]; // 숫자 문자열 추출

        validateNumbers(numbers.split(delimiter)); // 숫자 유효성 검사

        return sumNumbers(numbers.split(delimiter)); // 숫자의 합을 계산하여 반환
    }

    private String[] extractDelimiters(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            // 커스텀 구분자 사용 시
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            // 커스텀 구분자와 기본 구분자를 함께 사용 가능하도록 처리
            String combinedDelimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
            return new String[]{combinedDelimiters, numbers};
        }
        // 커스텀 구분자가 없을 경우 기본 구분자만 반환
        return new String[]{DEFAULT_DELIMITERS, input};
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.isEmpty()) { // 빈 문자열은 무시
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number); // 음수가 발견되면 예외 발생
                }
            }
        }
    }

    private int sumNumbers(String[] numbers) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String number : numbers) {
            if (!number.isEmpty()) { // 빈 문자열은 무시
                validNumbers.add(Integer.parseInt(number)); // 문자열을 정수로 변환하여 리스트에 추가
            }
        }
        return validNumbers.stream().mapToInt(Integer::intValue).sum(); // 리스트의 모든 숫자의 합 반환
    }
}
