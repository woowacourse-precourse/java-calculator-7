package calculator.domain;

import calculator.domain.number.Numbers;

public class Calculator {
    private int sum;

    public Calculator(Numbers numbers) {
        sumNumbers(numbers);
    }

    private void sumNumbers(Numbers numbers) {
        int sum = 0;
        for (Integer number : numbers.toInteger()) {
            sum += number;
        }
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }


}
