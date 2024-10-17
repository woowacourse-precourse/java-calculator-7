package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ApplicationView;

public class StringCalculatorApplication implements CalculatorApplication {

    private final ApplicationView applicationView;
    private final Calculator caclulator;

    public StringCalculatorApplication(ApplicationView applicationView, Calculator caclulator) {
        this.applicationView = applicationView;
        this.caclulator = caclulator;
    }

    @Override
    public void run() {
        try {
            String responseValue = applicationView.requestValue();
            int result = caclulator.calculate(responseValue);
            applicationView.printResult(result);
        } catch (IllegalArgumentException e) {
            applicationView.printError(e.getMessage());
        }
    }
}
