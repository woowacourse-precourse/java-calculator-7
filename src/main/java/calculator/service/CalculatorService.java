package calculator.service;

import calculator.util.Adder;
import calculator.util.InputValidator;
import calculator.util.Parser;
import calculator.domain.UserInput;
import java.util.List;

public class CalculatorService {
    public CalculatorService(){}

    public int calculate(String input){
        InputValidator.validate(input);

        boolean hasCustomDelimiter = Parser.hasCustomDelimiter(input);
        String string = hasCustomDelimiter ? input : input.replace(" ","");
        List<String> delimiters = hasCustomDelimiter ? List.of(Parser.extractCustomDelimiter(input)) : List.of(":",",");

        UserInput userInput = new UserInput(string, hasCustomDelimiter, delimiters);

        List<Integer> numbers = Parser.parseNumbersFromInput(userInput);
        return Adder.add(numbers);
    }
}
