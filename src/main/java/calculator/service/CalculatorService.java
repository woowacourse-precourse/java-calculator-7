package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.domain.Number;

import java.util.List;

public class CalculatorService {

    public int calculate(String input) {

        Delimiter delimiter = Delimiter.from(input);
        String numbers = delimiter.extractNumbers(input);
        List<Number> numberList = Calculator.splitAndParse(numbers, delimiter.getDelimiters());

        return Calculator.calculateSum(numberList);
    }

}
