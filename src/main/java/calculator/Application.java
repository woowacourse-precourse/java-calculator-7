package calculator;

import calculator.application.CalculatorService;
import calculator.application.dto.CalculatorSumRequest;
import calculator.domain.Calculator;
import calculator.domain.prompt.CalculatorPrompt;
import calculator.domain.prompt.Prompt;
import calculator.ui.CalculatorController;

public class Application {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new CalculatorService());
        calculatorController.stringAdditionCalculate();
    }

}
