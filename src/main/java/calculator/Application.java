package calculator;

import calculator.delimiter.CustomDelimiterHandler;
import calculator.delimiter.DefaultDelimiterHandler;
import calculator.delimiter.DelimiterChecker;
import calculator.delimiter.DelimiterHandler;
import calculator.io.input.ConsoleInputHandler;
import calculator.io.input.InputHandler;
import calculator.io.output.ConsoleOutputHandler;
import calculator.io.output.OutputHandler;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final InputHandler INPUT_HANDLER = new ConsoleInputHandler();
    private static final OutputHandler OUTPUT_HANDLER = new ConsoleOutputHandler();
    private static final DelimiterChecker DELIMITER_CHECKER = new DelimiterChecker();
    private static final List<String> DELIMITERS = new ArrayList<>(List.of(",", ":"));

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getUserInput();

        int result = 0;
        if (inputIsNotEmpty(input)) {
            DelimiterHandler delimiterHandler;
            if (isCustomDelimiter(input)) {
                String customDelimiter = extractCustomDelimiter(input);
                DELIMITERS.add(customDelimiter);
                delimiterHandler = new CustomDelimiterHandler();
            } else {
                delimiterHandler = new DefaultDelimiterHandler();
            }

            String numbersWithDelimiter = extractNumbersWithDelimiter(delimiterHandler, input);
            String[] splitNumbers = extractNumbersWithRegex(numbersWithDelimiter);

            for (String number : splitNumbers) {
                try {
                    int parsedNumber = Integer.parseInt(number);
                    validatePositiveNumber(parsedNumber);
                    result += parsedNumber;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자 이외의 값을 입력할 수 없습니다.");
                }
            }
        }
        OUTPUT_HANDLER.showAdditionResult(result);
    }

    private static String extractNumbersWithDelimiter(DelimiterHandler delimiterHandler, String input) {
        return delimiterHandler.getNumbersWithDelimiter(input);
    }

    private static String[] extractNumbersWithRegex(String numbersWithDelimiter) {
        return numbersWithDelimiter.split(buildDelimiterRegex());
    }

    private static String extractCustomDelimiter(String input) {
        int delimiterIdx = input.indexOf("\n");
        return input.substring(2, delimiterIdx);
    }

    private static String getUserInput() {
        OUTPUT_HANDLER.showUserInputMessage();
        return INPUT_HANDLER.getUserInput();
    }

    private static void validatePositiveNumber(int parsedNumber) {
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("입력값은 양수만 가능합니다.");
        }
    }

    private static String buildDelimiterRegex() {
        return String.join("|", DELIMITERS);
    }

    private static boolean isCustomDelimiter(String input) {
        return DELIMITER_CHECKER.isCustomDelimiter(input);
    }

    private static boolean inputIsNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

}
