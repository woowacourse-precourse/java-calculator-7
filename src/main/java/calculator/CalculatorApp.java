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
                    delimiterHandler = new CustomDelimiterHandler(delimiterChecker);
                }
            }

            String numbersWithDelimiter = extractNumbersWithDelimiter(userInput, delimiterHandler);
            String[] splitNumbers = extractNumbersWithRegex(numbersWithDelimiter);

            int result = calculator.execute(convertToIntArray(splitNumbers));
            outputHandler.showAdditionResult(result);
        } catch (CalculatorException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception ex) {
            outputHandler.showExceptionMessage(ex.getMessage());
        }
    }

    private boolean inputIsNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    private boolean isCustomDelimiter(String input) {
        return delimiterChecker.isCustomDelimiter(input);
    }

    private String extractCustomDelimiter(String input) {
        return delimiterChecker.extractCustomDelimiter(input);
    }

    private String extractNumbersWithDelimiter(String input, DelimiterHandler delimiterHandler) {
        return delimiterHandler.getNumbersWithDelimiter(input);
    }

    private String[] extractNumbersWithRegex(String numbersWithDelimiter) {
        return numbersWithDelimiter.split(delimiter.buildDelimiterRegex());
    }

    private static int[] convertToIntArray(String[] splitNumbers) {
        try {
            return Arrays.stream(splitNumbers).mapToInt(Integer::valueOf).toArray();
        } catch (NumberFormatException e) {
            throw new CalculatorException("입력값 중 숫자로 변환할 수 없는 값이 포함되어 있습니다.");
        }
    }

}
