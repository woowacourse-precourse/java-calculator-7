package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

import java.util.List;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Adder adder;
    private final InputValidator inputValidator;
    private final List<DelimiterStrategy> delimiterStrategies;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, Adder adder, InputValidator inputValidator, List<DelimiterStrategy> delimiterStrategies) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.adder = adder;
        this.inputValidator = inputValidator;
        this.delimiterStrategies = delimiterStrategies;
    }

    public void run() {
        outputHandler.showStartComments();
        String userInput = inputHandler.getUserInput();

        if (inputValidator.isEmptyOrNull(userInput)) {
            outputHandler.printResult(0);
            return;
        }

        String[] numbers = splitUsingStrategy(userInput);

        for (String number : numbers) {
            validateNumber(number);
        }

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

    private void validateNumber(String token) {
        inputValidator.validateIsNumeric(token);            // 숫자인지 확인
        inputValidator.validateInRange(token);              // 숫자가 int 범위에 있는지 확인
        int number = Integer.parseInt(token);               // 숫자로 변환
        inputValidator.validateNonNegative(number);         // 음수인지 검증
    }
}
