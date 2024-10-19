package calculator.validation;


public class OperandValidator {
    private static final String INVALID_OPERAND = "피연산자가 잘못 입력되었습니다.";


    public static int parseNumber(String token) {
        try {
            if (token == null || token.isEmpty()) {
                return 0;
            } 
            int number = Integer.parseInt(token);
            if (number <= 0) {
                throw new IllegalArgumentException(INVALID_OPERAND);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_OPERAND);
        }
    }

}
