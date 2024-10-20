package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {
    private final CalculatorController calculatorController;

    public Application(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    public void run() {
        calculatorController.run();
    }

    public static void main(String[] args) {
        Application app = new Application(new CalculatorController());
        app.run();
    }
}
