package calculator.model.operand;

import java.util.List;

public class IntegerOperand implements Operand {

    private final int[] numbers;

    public IntegerOperand(final List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("피연산자가 null일 수 없습니다.");
        }
    }

    @Override
    public int sum() {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    @Override
    public int subtract() {
        if (numbers.length == 0) {
            return 0;
        }
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    @Override
    public int multiply() {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    @Override
    public int divide() {
        if (numbers.length == 0) {
            throw new ArithmeticException("피연산자가 비어있습니다.");
        }
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
