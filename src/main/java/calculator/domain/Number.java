package calculator.domain;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(String value) {
        int validated = validate(value);
        return new Number(validated);
    }

    // 유효성 검사를 분리한 메서드
    private static int validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("구분자 사이에는 1개 이상의 숫자를 넣어야합니다.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 있는 숫자만 가능합니다: " + value);
        }
    }

    public int getValue() {
        return value;
    }
}
