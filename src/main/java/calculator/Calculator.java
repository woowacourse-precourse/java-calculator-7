package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final CalculatorController calculatorController;
    private final InputView inputView;
    private final OutputView outputView;

    private Calculator(CalculatorController calculatorController, InputView inputView, OutputView outputView) {
        this.calculatorController = calculatorController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class CalculatorHolder {
        private static final Calculator INSTANCE = new Calculator(CalculatorController.getInstance(),
                InputView.getInstance(), OutputView.getInstance());
    }

    public static Calculator getInstance() {
        return CalculatorHolder.INSTANCE;
    }

    public void run() {
//        while (true) {
        outputView.requestString();
        Long result = calculatorController.calculateNumbers(inputView.getNotSeparatedString());
        outputView.showResult(result);
//        Boolean isContinue = calculatorController.isContinue(inputView.readContinue());
//            if (!isContinue) {
//                return;
//            }
//        }
    }
}
