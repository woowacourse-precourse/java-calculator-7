package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.StringSplitter;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        StringSplitter stringSplitter = new StringSplitter();
        Calculator calculator = new Calculator(stringSplitter);

        CalculatorController controller = new CalculatorController(inputView, resultView, calculator);
        controller.run();
    }
}