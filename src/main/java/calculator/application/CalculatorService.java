package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.prompt.CalculatorPrompt;
import calculator.domain.prompt.Prompt;

public class CalculatorService {

    public int splitAndSum(String command) {
        Prompt prompt = new CalculatorPrompt(command);
        return new Calculator(prompt).sum();
    }

}
