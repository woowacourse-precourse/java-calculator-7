package calculator;

public class Converter {

    public int convertToValidInteger(String token) {
        String trimToken = (token.trim());
        if (trimToken.isEmpty()) {
            return 0;
        }
        try {
            int num = Integer.parseInt(trimToken);

            validateNonNegative(num);
            return num;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
    }


    private void validateNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
