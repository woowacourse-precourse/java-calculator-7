package calculator.validation;

public class Validator {
    private static final String INVALID_OPERAND = "피연산자가 잘못 입력되었습니다.";
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자가 정상적으로 입력되지 않았습니다.";


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

    public static void isValidDelimiter(String determiter){
        if (determiter.matches(".*\\d.*")){
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
    }

    public static void isThereSeparator(int delimiterEndIndex){
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
    }

}
