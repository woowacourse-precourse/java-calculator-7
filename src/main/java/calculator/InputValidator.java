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
        // 커스텀 구분자를 제외한 계산 대상 문자열 길이를 검사
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("계산 대상 문자열의 길이가 9자를 초과했습니다.");
        }
    }

    public static void validateConsecutiveDelimiters(String input, String delimiter) {
        // 연속된 구분자가 있는지 확인하는 정규 표현식
        String regex = "[" + Pattern.quote(delimiter) + "]{2,}";
        if (input.matches(".*" + regex + ".*")) {
            throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
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

    public static void validateNoDecimalNumbers(String input) {
        // 소수 값 찾기
        Matcher matcher = Pattern.compile("\\d+\\.\\d+").matcher(input);
        List<String> decimalNumbers = new ArrayList<>();
        while (matcher.find()) {
            decimalNumbers.add(matcher.group());
        }

        // 소수 값이 하나라도 있으면 예외 발생
        if (!decimalNumbers.isEmpty()) {
            throw new IllegalArgumentException("소수는 허용되지 않습니다: " + String.join(", ", decimalNumbers));
        }
    }

    public static void validateOnlyNumericAndDelimiters(String input, String delimiter) {
        // 숫자와 사용할 구분자 외의 문자가 포함되었는지 검사
        String regex = "[^\\d" + Pattern.quote(delimiter) + "]";
        if (input.matches(".*" + regex + ".*")) {
            throw new IllegalArgumentException("계산 대상 문자열에는 숫자와 구분자 외의 문자가 포함될 수 없습니다.");
        }
    }

}
