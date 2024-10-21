package calculator.domain;

public class Number {

    private static final String POSITIVE_NUMBER_PATTERN = "^[1-9]\\d*$";
    private final int value;

    public Number(String name) {
        validate(name);
        this.value = parseInt(name);
    }

    private void validate(String name) {
        if (!name.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다");
        }
    }

    private int parseInt(String name) {
        return Integer.parseInt(name);
    }

    public int getValue() {
        return value;
    }
}
