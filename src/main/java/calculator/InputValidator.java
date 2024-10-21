package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MAX_LENGTH = 9;

    public static boolean isEmptyString(String input) {
        return input.isEmpty();
    }

    public static void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("계산 대상 문자열의 길이가 9자를 초과했습니다.");
        }
    }

    public static void validateCustomDelimiterInputLength(String input) {
        String[] parts = input.split("\n", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 포맷입니다.");
        }
        String numbersPart = parts[1]; // 구분자 지정 부분을 제외한 계산 대상 문자열
        if (numbersPart.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("계산 대상 문자열의 길이가 9자를 초과했습니다.");
        }
    }

    public static void validateNoNegativeNumbers(String input) {
        // 음수 값 찾기
        Matcher matcher = Pattern.compile("-\\d+").matcher(input);
        List<String> negativeNumbers = new ArrayList<>();

        // 모든 음수 값을 리스트에 추가
        while (matcher.find()) {
            negativeNumbers.add(matcher.group());
        }

        // 음수 값이 하나라도 있으면 예외 발생
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + String.join(", ", negativeNumbers));
        }
    }
}
