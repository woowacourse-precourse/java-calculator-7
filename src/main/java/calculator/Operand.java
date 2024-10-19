package calculator;

public class Operand {
    private final int number;

    public Operand(String number) {
        validateIsDigit(number);
        validateIsPositive(number);
        this.number = Integer.parseInt(number);
    }

    private void validateIsDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 피연산자는 숫자여야 합니다.");
        }
    }

    private void validateIsPositive(String number) {
        if (Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException("[ERROR] 피연산자는 양수여야 합니다.");
        }
    }
}
