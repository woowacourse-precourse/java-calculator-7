package calculator.domain;

import java.util.List;

import static calculator.constant.ErrorMessages.OPERAND_NOT_POSITIVE;

public class Calculator {
    private List<Double> numbers;

    public Calculator(List<Double> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Number plus(){
        double result = 0;
        for(double number : numbers){
            result += number;
        }
        return formatResult(result);
    }

    private void validateNumbers(List<Double> numbers){
        for(double number : numbers){
            if(number <= 0){
                throw new IllegalArgumentException(OPERAND_NOT_POSITIVE);
            }
        }
    }

    private Number formatResult(double result){
        if(isInteger(result)){
            return (int) result;
        }
        return result;
    }

    public static boolean isInteger(double result) {
        return result % 1 == 0;
    }
}
