package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ApplicationView;

public class StringCalculatorApplication implements CalculatorApplication {

    private final ApplicationView applicationView;
    private final Calculator caculator;

    public StringCalculatorApplication(ApplicationView applicationView, Calculator caculator) {
        this.applicationView = applicationView;
        this.caculator = caculator;
    }

    @Override
    public void run() {
        try {
            String responseValue = applicationView.requestValue();
            int result = caculator.calculate(responseValue);
            applicationView.printResult(result);
        } catch (IllegalArgumentException e) {
            applicationView.printError(e.getMessage());
        }
    }
}
