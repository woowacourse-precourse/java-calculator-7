package calculator;

public class Converter {

    public double convertToValidNumber(String token) {
        String trimToken = (token.trim());
        if (trimToken.isEmpty()) {
            return 0;
        }
        try {
            double num = Double.parseDouble(trimToken);

            validateNonNegative(num);
            return num;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
    }


    private void validateNonNegative(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
