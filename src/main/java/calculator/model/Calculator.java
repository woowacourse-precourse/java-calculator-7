package calculator.model;

import calculator.parser.InputParser;
import calculator.validator.Validator;

import java.util.List;

public class Calculator {

    private final InputParser inputParser;
    private final Validator validator;

    public Calculator(InputParser inputParser, Validator validator) {
        this.inputParser = inputParser;
        this.validator = validator;
    }//Calculator

    public int calculate(String input) {

        //입력 유효성 검사
        if (validator.inputValidate(input)) {
            return 0;
        }

        List<Integer>numbers = inputParser.parse(input);

        return sum(numbers);
    }//calculate

    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }//sum
}//class
