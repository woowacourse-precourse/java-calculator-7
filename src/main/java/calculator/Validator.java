package calculator;

public class Validator {
    // 커스텀 분리자를 사용할 수 있는지 검증
    public static void validateCustomDelimiterUsage(String input, String customDelimiterStart, String customDelimiterEnd) {
        // 커스텀 구분자 기호로 시작, 끝 기호가 없는 경우
        if (input.startsWith(customDelimiterStart) && !input.contains(customDelimiterEnd)) {
            throwError();
        }
        // 커스텀 구분자 기호가 없지만 커스텀 구분자를 사용한 경우
        if (!input.startsWith(customDelimiterStart) && input.matches(".*[^0-9,;\\\\-\\\\.].*")) {
            throwError();
        }
    }

    // 커스텀 구분자는 존재하지만, 길이가 0인 경우
    public static void validateCustomDelimiterPresence(int index, int delimiterIndex) {
        if (index == delimiterIndex) {
            throwError();
        }
    }

    // 파싱된 숫자를 검증
    public static int validateNumber(int parsedNumber) {
        if (parsedNumber < 0) {
            throwError();
        }

        return parsedNumber;
    }

    // 외부에서 throwError 함수를 사용하기 위한 함수
    public static void use() {
        throwError();
    }

    // 오류를 throw하는 함수
    private static void throwError() {
        throw new IllegalArgumentException("커스텀 구분자를 정의할 수 없거나 잘못된 값이 입력되었습니다.");
    }
}
