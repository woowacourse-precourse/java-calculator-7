package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputProcessor inputProcessor = InputProcessor.getInstance();
        List<Integer> nums = inputProcessor.getInputFromUser();

        Calculator calculator = new Calculator();
        int result = calculator.calculateResult(nums);

        OutputProcessor outputProcessor = new OutputProcessor();
        outputProcessor.printResult(result);
    }
}
