package calculator;

import calculator.controller.CalculatorController;
import calculator.handler.InputHandler;
import calculator.model.DelimiterTokenizer;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();
        InputView inputView = new InputView();
        InputHandler inputHandler = new InputHandler(inputView);
        OutputView outputView = new OutputView();

        CalculatorController calculatorController =
                new CalculatorController(delimiterTokenizer, inputHandler, outputView);

        calculatorController.run();
    }

}
