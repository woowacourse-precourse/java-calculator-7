package calculator.domain;

import calculator.domain.number.Numbers;

public class Calculator {

    public int sumNumbers(Numbers numbers) {
        return numbers.toInteger().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
