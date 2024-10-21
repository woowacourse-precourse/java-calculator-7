package calculator.controller;

import calculator.utils.InputProcessor;
import calculator.views.OutputView;
import calculator.utils.Calculator;
import calculator.views.InputView;
import java.util.List;

public class Controller {
    public void executeProgram() {
        String input = getInput();
        List<Integer> nums = makeListFromString(input);
        int result = getResult(nums);
        printResult(result);
    }

    private String getInput() {
        InputView inputView = InputView.getInstance();
        return inputView.getInputFromUser();
    }

    private void printResult(int result) {
        OutputView outputView = OutputView.getInstance();
        outputView.printResult(result);
    }

    private List<Integer> makeListFromString(String input) {
        InputProcessor inputProcessor = InputProcessor.getInstance();
        return inputProcessor.processInput(input);
    }

    private int getResult(List<Integer> nums) {
        Calculator calculator = new Calculator();
        return calculator.calculateResult(nums);
    }
}
