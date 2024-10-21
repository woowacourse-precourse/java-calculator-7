package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculateService;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        CalculateService calculateService = new CalculateService();
        Input input = new Input();
        Output output = new Output();

        CalculatorController calculatorController = new CalculatorController(calculateService, input, output);
        calculatorController.run();
    }
}
