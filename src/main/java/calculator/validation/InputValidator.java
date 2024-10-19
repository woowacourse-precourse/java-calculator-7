package calculator.validation;


public class InputValidator {
    private static final String NON_NATURAL_NUMBER = "자연수가 아닌 값이 포함되어 있습니다.";


    private static int parsePositiveNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException(NON_NATURAL_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NATURAL_NUMBER);
        }
    }

}
