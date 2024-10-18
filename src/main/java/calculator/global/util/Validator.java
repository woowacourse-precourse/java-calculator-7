package calculator.global.util;

import static calculator.global.constant.ErrorMessage.*;


public class Validator {

    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    /**
     * startIndex 는 찾았지만 endIndex 를 찾지 못한 경우
     *
     * @param startIndex CustomIndex 의 시작 index
     * @param endIndex   CustomIndex 의 끝 index
     */
    public static void validateCustomIndex(int startIndex, int endIndex) {
        if (startIndex != -1 && endIndex == -1) {
            throw new IllegalArgumentException(CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE);
        }
    }

    public static void validateSeparator(String number) {
        try {
            validateNumberFormat(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
        }
        validateDashNumber(number);
    }

    private static void validateDashNumber(String number) {
        int absNum = Math.abs(Integer.parseInt(number));
        if(Integer.parseInt(number) != absNum){
            throw new IllegalArgumentException(UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
        }
    }
}
