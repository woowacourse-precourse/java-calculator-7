package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.Prompt;

public class CalculatorService {

    public int splitAndSum(String command) {
        Prompt prompt = new Prompt(command);
        return new Calculator(prompt).sum();
    }

}
