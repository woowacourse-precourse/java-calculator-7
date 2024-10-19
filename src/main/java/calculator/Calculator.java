package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

import java.util.List;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final List<DelimiterStrategy> delimiterStrategies;
    private final Adder adder;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, Adder adder, List<DelimiterStrategy> delimiterStrategies) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.adder = adder;
        this.delimiterStrategies = delimiterStrategies;
    }

    public void run() {
        outputHandler.showStartComments();
        String userInput = inputHandler.getUserInput();

        String[] numbers = splitUsingStrategy(userInput);
        int result = adder.calculateSum(numbers);  // 검증된 숫자로 계산
        outputHandler.printResult(result);
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
