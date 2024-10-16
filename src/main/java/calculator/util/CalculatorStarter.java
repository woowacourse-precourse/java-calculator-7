package calculator.util;

import calculator.view.CalculatorView;

public abstract class CalculatorStarter {

    private static final CalculatorView calculatorView =
            SingletonObjectProvider.getSingletonObject(CalculatorView.class);

    public static void start() {
        calculatorView.startCalculateProgram();
    }
}