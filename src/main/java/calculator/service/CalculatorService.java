package calculator.service;

import calculator.domain.Adder;
import calculator.domain.InputValidator;
import calculator.domain.Parser;
import calculator.domain.UserInput;
import java.util.List;

public class CalculatorService {
    public CalculatorService(){}

    public int calculate(String input){
        UserInput userInput = new UserInput(input);

        InputValidator.validate(userInput);

        List<Integer> numbers = Parser.parseNumbersFromInput(userInput.getInput(), userInput.getDelimiters());
        return Adder.add(numbers);
    }
}
