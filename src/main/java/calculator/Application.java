package calculator;

import calculator.controller.CalculateController;
import calculator.service.CalculatorService;
import calculator.utils.DelimiterFilter;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService(new Parser(), new DelimiterFilter());
        CalculateController calculateController = new CalculateController(new OutputView(), new InputView(),
                calculatorService);
        calculateController.start();
    }
}
