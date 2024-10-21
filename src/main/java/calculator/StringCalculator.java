package calculator;

public class StringCalculator {

    private final InputParser parser = new InputParser();

    public int calculateSum(String input) {
        String[] tokens = parser.parseTokens(input);
        return sumTokens(tokens);
    }

    private int parseToken(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.(" + token + ")");
        }
    }

    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseToken(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.(" + number +")");
            }
            sum += number;
        }
        return sum;
    }
}
