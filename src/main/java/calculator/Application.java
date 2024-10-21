package calculator;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputString = inputView.getInput();

        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(inputString);

        OutputView outputView = new OutputView();
        outputView.getOutput(result);
    }
}

