package calculator;

public class Validator {

    /**
     * 빈 입력인지 확인 (빈 문자열, 엔터, 탭, null)
     */
    public boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    /**
     * 입력이 정수인지 확인
     */
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 음수 입력인지 확인
     */
    public void isNegative(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException();
        }
    }
}
