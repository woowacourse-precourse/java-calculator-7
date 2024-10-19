package domain;

public class Number {

    int number;

    public int parseConvertInt(String token) {
        try {
            number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + token);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
        }
    }

}
