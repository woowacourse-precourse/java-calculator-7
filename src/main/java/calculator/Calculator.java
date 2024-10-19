package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:"; // 기본 구분자

    public int calculate(String input) {
        if (isEmptyInput(input)) {
            return 0; // 빈 문자열이 입력되면 0을 반환
        }
        String delimiter = extractDelimiter(input); // 구분자 추출
        input = extractNumbers(input, delimiter); // 숫자 추출
        return sumNumbers(input.split(delimiter)); // 숫자를 합산하여 결과 반환
    }

    // 빈 문자열 또는 null을 확인하는 메서드
    private boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    // 구분자를 추출하는 메서드
    private String extractDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;

        // 커스텀 구분자 여부 체크
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//\\[(.+)]\\n(.*)").matcher(input);

            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 추출
                input = matcher.group(2); // 숫자 부분 추출
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        // 기본 구분자와 커스텀 구분자를 결합
        return delimiter + "|" + DEFAULT_DELIMITER;
    }

    // 숫자를 추출하는 메서드
    private String extractNumbers(String input, String delimiter) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);
        }
        return input; // 기본 구분자 사용 시 원본 입력 반환
    }

    // 숫자를 합산하는 메서드
    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number);
        }
        return sum;
    }

    // 각 숫자 문자열을 정수로 변환하고 예외 처리
    private int parseNumber(String number) {
        if (number.trim().isEmpty()) {
            return 0; // 빈 문자열은 0으로 처리
        }
        if (!isNumeric(number.trim())) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
        }
        int num = Integer.parseInt(number.trim());
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
        return num;
    }

    // 문자열이 숫자인지 확인하는 메서드
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
