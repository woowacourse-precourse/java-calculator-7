package calculator;

public class Converter {

    public int convertToValidInteger(String token) {
        try {
            String trimToken = (token.trim());
            int num = Integer.parseInt(trimToken);

            validateNonNegative(num);
            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
    }

    public void validateInputString(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백이거나 빈 문자열입니다.");
        }
    }

    private void validateNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
