package calculator;

import calculator.controller.CalculatorController;
import calculator.service.SeparatorService;
import calculator.service.impl.SeparatorServiceImpl;
import calculator.viewer.ConsoleView;

public class Application {

    public static void main(String[] args) {

        ConsoleView consoleView = new ConsoleView();
        SeparatorService separatorService = new SeparatorServiceImpl();
        CalculatorController controller = new CalculatorController(separatorService, consoleView);

        controller.run();
    }
}
