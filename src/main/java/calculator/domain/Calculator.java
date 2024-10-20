package calculator.domain;

import java.util.*;

import static calculator.utils.ValidatorUtils.validateNumbers;

public class Calculator {
    private final List<Double> numbers;

    public Calculator(List<Double> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Number getSum(){
        Double sum = 0.0;

        for (Double number : numbers) {
            sum += number;
        }

        if(sum == sum.longValue()){
            return sum.longValue();
        }

        return sum;
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}
