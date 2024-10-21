package calculator.controller;

import calculator.io.InputProcessor;
import calculator.views.OutputView;
import calculator.utils.Calculator;
import calculator.views.InputView;
import java.util.List;

public class Controller {
    public void executeProgram() {
        String input = getInput();

        InputProcessor inputProcessor = InputProcessor.getInstance();
        List<Integer> nums = inputProcessor.processInput(input);

        Calculator calculator = new Calculator();
        int result = calculator.calculateResult(nums);

        OutputView outputView = OutputView.getInstance();
        outputView.printResult(result);
    }

    private String getInput() {
        InputView inputView = InputView.getInstance();
        return inputView.getInputFromUser();
    }
}
