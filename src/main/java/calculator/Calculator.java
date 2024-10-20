package calculator;

public abstract class Calculator {
    protected String input;

    protected Calculator(String input) {
        this.input = input;
    }

    public abstract int calculate();

    protected int sumPositiveNumbers(String[] parts) {
        int result = 0;
        for (String part : parts) {
            int target = Integer.parseInt(part);
            if (target > 0) {
                result += target;
            } else {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
        return result;
    }
}