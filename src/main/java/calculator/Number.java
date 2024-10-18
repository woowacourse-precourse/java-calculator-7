package calculator;

public class Number {
    private final Long inputNumber;
    private static final Long MAX_VALUE = 1000000000L;

    public Number(String inputString) {
        try {
            this.inputNumber = Long.parseLong(inputString);
            validate();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + inputString);
        }
    }

    private void validate() {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + inputNumber);
        }

        if (inputNumber > MAX_VALUE) {
            throw new IllegalArgumentException("숫자 최대값인 10억을 초과할 수 없습니다.");
        }
    }

    public Long getInputNumbers() {
        return inputNumber;
    }
}
