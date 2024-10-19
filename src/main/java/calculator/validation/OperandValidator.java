package calculator.validation;


public class OperandValidator {
    private static final String NON_NATURAL_NUMBER = "음수나 숫자가 아닌 것이 포함되어 있습니다.";


    public static int parseNumber(String token) {
        try {
            if (token == null || token.isEmpty()) {
                return 0;
            } 
            int number = Integer.parseInt(token);
            if (number <= 0) {
                throw new IllegalArgumentException(NON_NATURAL_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NATURAL_NUMBER);
        }
    }

}
