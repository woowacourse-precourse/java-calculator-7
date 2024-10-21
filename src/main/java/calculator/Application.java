package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.Separator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Separator separator = new Separator();
        Calculator calculator = new Calculator();

        CalculatorService calculatorService = new CalculatorService(calculator, delimiterExtractor, separator);

        CalculatorController controller = new CalculatorController(inputView, resultView, calculatorService);
        controller.run();
    }
}
