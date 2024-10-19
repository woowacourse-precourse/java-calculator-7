package calculator.model.operand;

import java.util.List;

public class IntegerOperand implements Operand {

    private final int[] numbers;

    public IntegerOperand(final List<Integer> numbers) {
        this.numbers = numbers.stream().mapToInt(Integer::intValue).toArray();
        validateSize(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("피연산자가 비어있을 수 없습니다.");
        }
    }

    @Override
    public int sum() {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    @Override
    public int subtract() {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    @Override
    public int multiply() {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }

    @Override
    public int divide() {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int divisor = numbers[i];
            if (divisor == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            result /= divisor;
        }
        return result;
    }
}
