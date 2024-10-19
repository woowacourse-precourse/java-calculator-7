package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.common.exception.InvalidDelimiterException;
import calculator.common.exception.InvalidNumberFormatException;
import calculator.common.exception.NegativeNumberException;
import calculator.common.io.Input;
import calculator.common.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

            List<String> delimiters;
            String numbers;

            if (hasCustomDelimiter(userInput)) {
                delimiters = extractAndValidateCustomDelimiter(userInput);
                numbers = extractNumbers(userInput);
            } else {
                delimiters = getDefaultDelimiters();
                numbers = userInput;
            }

            int result = calculateSum(splitNumbers(numbers, delimiters));
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            throw e;
        }
    }

    private static List<String> getDefaultDelimiters() {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        return delimiters;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    private static String extractNumbers(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        return input.substring(delimiterEndIndex + 2);
    }

    private static List<String> extractAndValidateCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");

        if (delimiterEndIndex == -1) {
            throw InvalidDelimiterException.invalidCustomDelimiterFormat();
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);

        if (customDelimiter.length() != 1) {
            throw InvalidDelimiterException.invalidCustomDelimiter();
        }

        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw InvalidDelimiterException.duplicateWithDefaultDelimiter();
        }

        List<String> delimiters = getDefaultDelimiters();
        delimiters.add(customDelimiter);
        return delimiters;
    }

    private static int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new NegativeNumberException(token);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(token);
        }
    }

    private static int calculateSum(String[] tokens) {
        return List.of(tokens).stream()
                .mapToInt(Application::parseAndValidateNumber)
                .sum();
    }

    private static String[] splitNumbers(String numbers, List<String> delimiters) {
        String delimiterPattern = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        return numbers.split(delimiterPattern);
    }
}