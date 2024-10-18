package calculator;

/**
 * 문자열의 유효성을 검증하는 클래스입니다.
 */
public class Validator {

    /**
     * 빈 입력인지 확인 (빈 문자열, 엔터, 탭, null)
     */
    public boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    /**
     * 입력이 양의 정수인지 확인
     */
    public boolean isInteger(String input) {
        try {
            int num = Integer.parseInt(input.trim());
            return num >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 음수가 포함된 입력인지 확인
     */
    public void isNegative(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException();
        }
    }
}
