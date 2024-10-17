package calculator;

import calculator.delimiter.CustomDelimiterHandler;
import calculator.delimiter.DefaultDelimiterHandler;
import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterChecker;
import calculator.delimiter.DelimiterHandler;
import calculator.io.input.ConsoleInputHandler;
import calculator.io.input.InputHandler;
import calculator.io.output.ConsoleOutputHandler;
import calculator.io.output.OutputHandler;
import calculator.operations.AdditionStrategy;
import calculator.operations.Calculator;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final InputHandler INPUT_HANDLER = new ConsoleInputHandler();
    private static final OutputHandler OUTPUT_HANDLER = new ConsoleOutputHandler();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getUserInput();

        int result = 0;
        List<String> defaultDelimiters = List.of(",", ":");
        Delimiter delimiter = new Delimiter(defaultDelimiters);
        DelimiterChecker delimiterChecker = new DelimiterChecker("//", "\n");

        if (inputIsNotEmpty(input)) {
            DelimiterHandler delimiterHandler;
            if (isCustomDelimiter(input, delimiterChecker)) {
                String customDelimiter = extractCustomDelimiter(input);
                delimiter.addDelimiter(customDelimiter);
                delimiterHandler = new CustomDelimiterHandler();
            } else {
                delimiterHandler = new DefaultDelimiterHandler();
            }

            String numbersWithDelimiter = extractNumbersWithDelimiter(delimiterHandler, input);
            String[] splitNumbers = extractNumbersWithRegex(numbersWithDelimiter, delimiter);

            Calculator calculator = new Calculator(new AdditionStrategy());
            result = calculator.execute(convertToIntArray(splitNumbers));
        }
        OUTPUT_HANDLER.showAdditionResult(result);
    }

    private static int[] convertToIntArray(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static String extractNumbersWithDelimiter(DelimiterHandler delimiterHandler, String input) {
        return delimiterHandler.getNumbersWithDelimiter(input);
    }

    private static String[] extractNumbersWithRegex(String numbersWithDelimiter, Delimiter delimiter) {
        return numbersWithDelimiter.split(delimiter.buildDelimiterRegex());
    }

    private static String extractCustomDelimiter(String input) {
        int delimiterIdx = input.indexOf("\n");
        return input.substring(2, delimiterIdx);
    }

    private static String getUserInput() {
        OUTPUT_HANDLER.showUserInputMessage();
        return INPUT_HANDLER.getUserInput();
    }

    private static boolean isCustomDelimiter(String input, DelimiterChecker delimiterChecker) {
        return delimiterChecker.isCustomDelimiter(input);
    }

    private static boolean inputIsNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

}
