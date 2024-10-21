package calculator;

import calculator.controller.Calculation;
import calculator.controller.FunctionOperator;
import calculator.controller.IOProcessor;
import calculator.controller.Preprocessing;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();

        IOProcessor ioProcessor = new IOProcessor(inputView, outputView, preprocessing);
        Calculation calculation = new Calculation();

        FunctionOperator operator = new FunctionOperator(ioProcessor, calculation);
        operator.run();
    }
}
