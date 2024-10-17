package calculator;

import calculator.delimiter.CustomDelimiterHandler;
import calculator.delimiter.DefaultDelimiterHandler;
import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterChecker;
import calculator.delimiter.DelimiterHandler;
import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;
import calculator.operations.Calculator;
import java.util.Arrays;

public class CalculatorApp implements CalculatorRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final DelimiterChecker delimiterChecker;
    private final Delimiter delimiter;
    private final Calculator calculator;

    public CalculatorApp(InputHandler inputHandler, OutputHandler outputHandler,
                         DelimiterChecker delimiterChecker, Delimiter delimiter, Calculator calculator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.delimiterChecker = delimiterChecker;
        this.delimiter = delimiter;
        this.calculator = calculator;
    }

    @Override
    public void run() {
        outputHandler.showUserInputMessage();

        try {
            String userInput = inputHandler.getUserInput();

            DelimiterHandler delimiterHandler = new DefaultDelimiterHandler();
            if (inputIsNotEmpty(userInput)) {
                if (isCustomDelimiter(userInput)) {
                    String customDelimiter = extractCustomDelimiter(userInput);
                    delimiter.addDelimiter(customDelimiter);
                    delimiterHandler = new CustomDelimiterHandler();
                }
            }

            String numbersWithDelimiter = extractNumbersWithDelimiter(userInput, delimiterHandler);
            String[] splitNumbers = extractNumbersWithRegex(numbersWithDelimiter);

            int result = calculator.execute(convertToIntArray(splitNumbers));
            outputHandler.showAdditionResult(result);
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }

    private boolean inputIsNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    private boolean isCustomDelimiter(String input) {
        return delimiterChecker.isCustomDelimiter(input);
    }

    private String extractCustomDelimiter(String input) {
        int delimiterIdx = input.indexOf("\n");
        return input.substring(2, delimiterIdx);
    }

    private String extractNumbersWithDelimiter(String input, DelimiterHandler delimiterHandler) {
        return delimiterHandler.getNumbersWithDelimiter(input);
    }

    private String[] extractNumbersWithRegex(String numbersWithDelimiter) {
        return numbersWithDelimiter.split(delimiter.buildDelimiterRegex());
    }

    private static int[] convertToIntArray(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
