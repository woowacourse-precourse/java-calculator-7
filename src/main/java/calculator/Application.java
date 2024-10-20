package calculator;

import calculator.controller.InputController;
import calculator.controller.OutputController;
import calculator.service.StringAdditionService;

public class Application {
    public static void main(String[] args) {
        String input = InputController.getInput();
        int result = StringAdditionService.calculateSum(input);
        OutputController.printResult(result);
    }
}
