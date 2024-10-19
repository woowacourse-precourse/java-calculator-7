package calculator.domain;

import java.util.List;

public class Calculator {
    private List<Double> numbers;

    public Calculator(List<Double> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public double plus(){
        double result = 0;
        for(Double number : numbers){
            result += number;
        }
        return result;
    }

    private void validateNumbers(List<Double> numbers){
        for(double number : numbers){
            if(number <= 0){
                throw new IllegalArgumentException("피연산자가 양수가 아닙니다.");
            }
        }
    }
}
