package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CalculateService;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringParser stringParser = new StringParser();
        CalculateService calculateService = new CalculateService();

        CalculatorController calculatorController = new CalculatorController(inputView, outputView, stringParser,
                calculateService);
        calculatorController.run();
    }
}
