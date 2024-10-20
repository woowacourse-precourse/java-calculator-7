package calculator;

import calculator.io.InputProcessor;
import calculator.io.OutputProcessor;
import calculator.utils.Calculator;
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
