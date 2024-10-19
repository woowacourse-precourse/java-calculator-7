package calculator.domain;

import java.util.*;

import static calculator.utils.MyStringUtils.buildRegexFromSet;

public class Calculator {
    private final List<Double> numbers;

    public Calculator(List<Double> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Double> numbers){
        for (Double number : numbers) {
            if(number <= 0){
                throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
            }
        }
    }

    public Double getSum(){
        Double sum = 0.0;

        for (Double number : numbers) {
            sum += number;
        }

        return sum;
    }
    public List<Double> getNumbers() {
        return numbers;
    }
}
