package calculator;

import calculator.util.Container;
import calculator.view.CalculatorView;
import calculator.view.OutputView;

public class Calculator {

    private static final OutputView outputView = Container.getInstance(OutputView.class);
    private static final CalculatorView calculatorView = Container.getInstance(CalculatorView.class);

    public static void start() {
        try {
            outputView.printStartMessage();
            int result = calculatorView.startProgram();
            outputView.printResult(result);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            throw e;
        }
    }
}
