package calculator;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.common.io.Input;
import calculator.common.io.Output;
import calculator.domain.Number;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        try {
            String userInput = input.getInput();

            if (isEmpty(userInput)) {
                output.printResult(0);
                return;
            }
            Delimiter delimiter = Delimiter.from(userInput);
            String numbers = delimiter.extractNumbers(userInput);
            List<Number> numberList = Calculator.splitAndParse(numbers, delimiter.getDelimiters());

            int result = Calculator.calculateSum(numberList);
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            throw e;
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}