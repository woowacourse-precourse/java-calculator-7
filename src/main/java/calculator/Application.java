package calculator;

import calculator.controller.Calculation;
import calculator.controller.FunctionOperator;
import calculator.controller.Preprocessing;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        Calculation calculation = new Calculation();

        FunctionOperator operator = new FunctionOperator(inputView, outputView, preprocessing, calculation);
        operator.run();
    }
}
