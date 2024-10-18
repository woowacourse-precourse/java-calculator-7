package calculator.service;

import calculator.domain.Adder;
import calculator.domain.InputValidator;
import calculator.domain.Parser;
import java.util.List;

public class CalculatorService {
    public CalculatorService(){}

    public int calculate(String input){
        InputValidator.validate(input);

        List<String> delimiters = getDelimitersList(input);
        List<Integer> numbers = Parser.parseNumbersFromInput(input, delimiters);
        return Adder.add(numbers);
    }

    private List<String> getDelimitersList(String input) {
        if(Parser.hasCustomDelimiter(input))
            return List.of(Parser.extractCustomDelimiter(input));
        else
            return List.of(":",",");
    }
}
