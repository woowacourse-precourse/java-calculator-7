package calculator;

public class NumberParser {

    public int parsePositiveInt(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }
}
