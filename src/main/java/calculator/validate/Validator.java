package calculator.validate;

import java.util.List;

public class Validator {

    private static final int NOT_FOUND = -1;
    private static final int SINGLE_CHARACTER_LENGTH = 1;
    private static final int NEGATIVE_BOUNDARY = 0;

    public static void validateCustomDelimiterPositions(int startIndex, int endIndex) {
        if (startIndex == NOT_FOUND || endIndex == NOT_FOUND) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    public static void validateDelimiterLength(String delimiter) {
        if (delimiter.length() != SINGLE_CHARACTER_LENGTH) {
            throw new IllegalArgumentException("구분자는 하나의 문자여야 합니다.");
        }
    }

    public static void handleConversionError(String inputStringPart) {
        throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 있습니다: " + inputStringPart);
    }

    public static void validateInputStringAndDelimiters(String inputString, List<String> delimiters) {
        validateStringInput(inputString);
        validateDelimiters(delimiters);
    }

    private static void validateStringInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        }
    }

    private static void validateDelimiters(List<String> delimiters) {
        if (delimiters == null || delimiters.isEmpty()) {
            throw new IllegalArgumentException("구분자 리스트가 비어 있습니다.");
        }
    }

    public static void validateNegativeNumber(int number, boolean allowNegativeNumbers, String inputStringPart) {
        if (!allowNegativeNumbers && number < NEGATIVE_BOUNDARY) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + inputStringPart);
        }
    }
}
