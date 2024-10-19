package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final List<DelimiterStrategy> delimiterStrategies;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, List<DelimiterStrategy> delimiterStrategies) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.delimiterStrategies = delimiterStrategies;
    }

    public void run() {
        outputHandler.showStartComments();
        String userInput = inputHandler.getUserInput();

        String[] numbers = splitUsingStrategy(userInput);
        System.out.println(Arrays.toString(numbers));
        outputHandler.printResult(0);
    }

    private String[] splitUsingStrategy(String userInput) {
        for (DelimiterStrategy strategy : delimiterStrategies) {
            if (strategy.matches(userInput)) {
                return strategy.splitNumbers(userInput);
            }
        }
        throw new IllegalArgumentException("적합한 구분자 전략이 없습니다.");
    }
}
