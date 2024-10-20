package calculator.domain;

import calculator.domain.number.Numbers;

public class Calculator {
    private int sum;

    public Calculator(Numbers numbers) {
        sumNumbers(numbers);
    }

    private void sumNumbers(Numbers numbers) {
        this.sum = numbers.toInteger().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getSum() {
        return sum;
    }
}
