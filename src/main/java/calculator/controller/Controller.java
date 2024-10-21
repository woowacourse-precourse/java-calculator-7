package calculator.controller;

import calculator.io.InputProcessor;
import calculator.io.OutputProcessor;
import calculator.utils.Calculator;
import calculator.views.InputView;
import java.util.List;

public class Controller {
    public void executeProgram() {
        InputView inputView = InputView.getInstance();
        String input = inputView.getInputFromUser();

        InputProcessor inputProcessor = InputProcessor.getInstance();
        List<Integer> nums = inputProcessor.processInput(input);

        Calculator calculator = new Calculator();
        int result = calculator.calculateResult(nums);

        OutputProcessor outputProcessor = new OutputProcessor();
        outputProcessor.printResult(result);
    }
}
