package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.io.ConsoleInputHandler;
import calculator.controller.io.ConsoleOutputHandler;
import calculator.model.CalculatorModel;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculator = new CalculatorController(new ConsoleInputHandler(),
                new ConsoleOutputHandler(), new CalculatorModel());
        calculator.run();
    }
}
