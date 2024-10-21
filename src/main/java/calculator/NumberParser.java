package calculator;

public class NumberParser {

    public int parse(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }
}