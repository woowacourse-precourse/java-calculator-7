package calculator;

public class StringCalculator {
    public int calculateSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseToken(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.(" + number + ")");
            }
            sum += number;
        }
        return sum;
    }

    private int parseToken(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.(" + token + ")");
        }
    }
}