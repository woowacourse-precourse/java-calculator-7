package calculator;

import calculator.domain.machine.Engine;
import calculator.domain.machine.View;

public class CalculatorApp {

    private final Engine calculatorEngine;
    private final View view;

    public CalculatorApp() {
        AppConfig appConfig = new AppConfig();
        this.calculatorEngine = appConfig.calculatorMachine();
        this.view = appConfig.view();
    }

    public void run() {
        view.printInputRequestMsg();
        String readLine = view.readInputMsg();

        Long result = calculatorEngine.operate(readLine);

        view.printResult(result);
    }
}
