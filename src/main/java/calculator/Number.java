package calculator;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(String value) {
        validate(value);
        return new Number(Integer.parseInt(value));
    }

    private static void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("구분자 사이에는 1개 이상의 숫자를 넣어야합니다.");
        }
        try {
            int tempNum = Integer.parseInt(value);
            if (tempNum < 0) {
                throw new IllegalArgumentException("정수로 변환할 수 있는 양수만 계산할 수 있습니다: " + value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 있는 양수만 계산할 수 있습니다: " + value);
        }
    }

    public int getValue() {
        return value;
    }
}
