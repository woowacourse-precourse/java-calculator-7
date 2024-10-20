package calculator.domain;

/**
 * 입력 받은 문자열 중 숫자를 랩핑하는 클래스
 */
public class Number {

    private final int value;

    public Number(int value) {
        validateNonNegative(value);
        this.value = value;
    }

    public Number(String input) {
        this.value = parseAndValidate(input);
    }

    // 입력으로 받은 문자열을 int로 변환하고 유효성을 검사한다.
    private int parseAndValidate(String input) {
        int result = validateParseInt(input);
        validateNonNegative(result);
        return  result;
    }

    private int validateParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 값이 유효한 정수가 아닙니다.", input));
        }
    }

    private void validateNonNegative(int number) {
        if(number < 0) {
            throw new IllegalArgumentException(String.format("%d 값이 0이상의 정수가 아닙니다.", number));
        }
    }

    public int getValue() {
        return value;
    }
}
