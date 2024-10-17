package calculator;

public class Calculator {

    private static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다";
    private static final String INVALID_NUMBER_ERROR = "잘못된 숫자 형식입니다";

    public int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR, e);
        }
    }

    public int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}