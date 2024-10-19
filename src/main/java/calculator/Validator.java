package calculator;

public class Validator {
    // 커스텀 분리자를 사용할 수 있는지 검증
    public static void validateCustomDelimiterUsage(String input, String customDelimiterStart, String customDelimiterEnd) {
        // 커스텀 구분자 기호로 시작, 끝 기호가 없는 경우
        if (input.startsWith(customDelimiterStart) && !input.contains(customDelimiterEnd)) {
            throwError("커스텀 분리자의 끝 기호가 없습니다. 커스텀 구분자를 정의할 수 없습니다.");
        }
        // 커스텀 구분자 기호가 없지만 커스텀 구분자를 사용한 경우
        if (!input.startsWith(customDelimiterStart) && input.matches(".*[^0-9,:].*")) {
            throwError("커스텀 분리자의 시작 기호와 끝 기호가 없습니다. 커스텀 구분자를 정의할 수 없습니다.");
        }
    }

    // 커스텀 구분자는 존재하지만, 길이가 0인 경우
    public static void validateCustomDelimiterPresence(int index, int delimiterIndex) {
        if (index == delimiterIndex) {
            throwError("커스텀 구분자의 길이가 0입니다. 커스텀 구분자를 정의할 수 없습니다.");
        }
    }

    // 파싱된 숫자를 검증
    public static int validateNumber(int parsedNumber) {
        if (parsedNumber < 0) {
            throwError("커스텀 구분자를 설정할 수 없거나 유효하지 않은 숫자입니다.");
        }

        return parsedNumber;
    }

    // 외부에서 throwError 함수를 사용하기 위한 함수
    public static void use(String message) {
        throwError(message);
    }

    // 오류를 throw하는 함수
    private static void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

}
