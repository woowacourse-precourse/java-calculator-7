package calculator;

import calculator.controller.CalculatorController;
import calculator.model.DelimiterTokenizer;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(delimiterTokenizer, inputView, outputView);
        calculatorController.run();
    }

}
