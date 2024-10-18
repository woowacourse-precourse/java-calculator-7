package calculator.controller;

import calculator.facade.CalculatorFacade;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigInteger;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorFacade calculatorFacade;

    public CalculatorController(
            final InputView inputView,
            final OutputView outputView,
            final CalculatorFacade calculatorFacade
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorFacade = calculatorFacade;
    }

    public void run() {
        final String inputString = requestInputString();
        final BigInteger result = calculatorFacade.calculatorIntegerSum(inputString);
        responseResult(result);
    }

    private void responseResult(final BigInteger result) {
        outputView.printResult(result);
    }

    private String requestInputString() {
        outputView.printAskInputString();
        return inputView.read();
    }

}
