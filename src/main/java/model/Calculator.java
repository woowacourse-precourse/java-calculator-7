package model;

public class Calculator {

    public static final String INTEGER_NOT_NEGATIVE_MESSAGE = "음수는 입력할 수 없습니다.";
    public static final String INVALID_NUMBER_MESSAGE = "잘못된 숫자가 입력되었습니다: ";

    public int operationAdd(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                if (!isValidNumber(token)) {
                    throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE + token);
                }
                if (Integer.parseInt(token) < 0) {
                    throw new IllegalArgumentException(INTEGER_NOT_NEGATIVE_MESSAGE);
                }
                result += Integer.parseInt(token);
            }
        }
        return result;
    }

    private boolean isValidNumber(String token) {
        return token.matches("-?\\d+");
    }
}
