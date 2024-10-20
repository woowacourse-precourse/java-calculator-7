package calculator;

public class Validator {
    private static final String ERROR_MESSAGE = "잘못된 문자 포함됨";

    public void validateDefaultInput(String input) {
//        for (char c : input.toCharArray()) {
//            if (isInvalidCharacter(c)) {
//                throw new IllegalArgumentException(ERROR_MESSAGE);
//            }
//        }
        String regex = "^[0-9:,]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

//    private boolean isInvalidCharacter(char c) {
//        return !Character.isDigit(c) && c != ':' && c != ','; // TODO
//    }

    public void validateCustomInput(String input, String customDelimiter) {
        String regex = "^([0-9:,]+|(" + customDelimiter + "))*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }
}
