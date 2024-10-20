package calculator;

import calculator.console.ConsoleReader;
import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(new OutputView(),
                new CalculatorService(),
                new ConsoleReader());
        controller.run();
    }
}
