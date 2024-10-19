package calculator;

public class Validator {

    public Integer isValid(String token) {
        if (token == null || token.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(token);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumber(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
