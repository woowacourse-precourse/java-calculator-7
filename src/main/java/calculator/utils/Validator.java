package calculator.utils;

public class Validator {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자이여야 합니다.";

    public static void isNumber(String[] tokens) {
        for (String token : tokens) {
            try {
                Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            }
        }
    }
}
