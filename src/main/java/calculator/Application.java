package calculator;

import calculator.application.CalculatorService;
import calculator.application.dto.CalculatorSumRequest;
import calculator.domain.Calculator;
import calculator.domain.prompt.CalculatorPrompt;
import calculator.domain.prompt.Prompt;

public class Application {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        int sum = calculatorService.splitAndSum(new CalculatorSumRequest("1,2:3"));
        System.out.println(sum);
    }

}
