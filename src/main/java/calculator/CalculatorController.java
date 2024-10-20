package calculator;

import calculator.dto.CalculatorResultResponse;
import calculator.dto.NumberRequest;

public class CalculatorController {
    CalculatorView calculatorView;
    CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void run() {
        NumberRequest numberRequest = calculatorView.welcomeMessage();
        CalculatorResultResponse result = calculatorModel.calculateSum(numberRequest);
        calculatorView.resultResponseMessage(result);
    }
}
