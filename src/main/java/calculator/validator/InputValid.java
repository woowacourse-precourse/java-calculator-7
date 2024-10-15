package calculator.validator;

import calculator.exception.InputValidationException;

public class InputValid {
    // 전체 글자 길이 제한 1 -100
    public static void checkStringLength(String str) {
        if (str.length() > 100) {
            throw new IllegalArgumentException(InputValidationException.TOO_LONG_STRING.getMessage());
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(InputValidationException.EMPTY_STRING.getMessage());
        }
    }

    // '// \n으로 시작하는지 정규식으로 확인
    public static boolean checkStartWithCustomSeparator(String str) {
        String regex = "^//.*?\n.*";
        if (!str.matches(regex)) {
            return true;
        }
        return false;
    }

    // 커스텀 구분자 길이 제한
    public static void checkCustomSeparatorLength(String separator) {
        if (separator.length() > 5) {
            throw new IllegalArgumentException(InputValidationException.TOO_LONG_CUSTOM_SEPARATOR.getMessage());
        }
        if (separator.isEmpty()) {
            throw new IllegalArgumentException(InputValidationException.EMPTY_CUSTOM_SEPARATOR.getMessage());
        }
    }

    // 구분자 기준으로 잘랐을 때 내부 글자 -  숫자만 있는가? / 숫자의 길이는?
    public static void checkNumber(String number) {
        String regex = "^\\d{1,20}$";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException(InputValidationException.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    // 숫자 개수 제한
    public static void checkNumberCount(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(InputValidationException.NO_NUMBERS.getMessage());
        }
        if (count > 100) {
            throw new IllegalArgumentException(InputValidationException.TOO_MANY_NUMBERS.getMessage());
        }
    }
}