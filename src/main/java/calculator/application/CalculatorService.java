package calculator.application;

import calculator.application.dto.CalculatorSumRequest;
import calculator.domain.Calculator;
import calculator.domain.prompt.CalculatorPrompt;
import calculator.domain.prompt.Prompt;

public class CalculatorService {

    public int splitAndSum(CalculatorSumRequest request) {
        Prompt prompt = new CalculatorPrompt(request.input());
        return new Calculator(prompt).sum();
    }

}
