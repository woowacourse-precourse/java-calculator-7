package calculator.controller;

import calculator.model.service.Calculator;
import calculator.view.ApplicationView;

public class StringCalculatorApplication implements CalculatorApplication {

    private final ApplicationView applicationView;
    private final Calculator calculator;

    public StringCalculatorApplication(ApplicationView applicationView, Calculator calculator) {
        this.applicationView = applicationView;
        this.calculator = calculator;
    }

    @Override
    public void run() {
            String responseValue = applicationView.requestValue();
            int result = calculator.calculate(responseValue);
            applicationView.printResult(result);
    }
}
