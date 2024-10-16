package calculator.service.util;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.CalculatorErrorMessage;
import calculator.domain.model.ExtractedInput;
import java.util.ArrayList;
import java.util.List;

public final class InputParser {
    public static List<Integer> parseByDelimiters(ExtractedInput extractedInput) {
        String remainingInput = extractedInput.getRemainingInput();
        String delimiters = extractedInput.getDelimiters();

        if (remainingInput.isEmpty()) {
            return new ArrayList<>();
        }

        String[] tokens = splitByDelimiters(remainingInput, delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = parseToInt(token);
            numbers.add(number);
        }

        return numbers;
    }

    private static String[] splitByDelimiters(String input, String delimiters) {
        return input.split(delimiters);
    }

    private static int parseToInt(String numberString) {
        try {
            return Integer.parseInt(numberString.trim());
        } catch (NumberFormatException e) {
            throw CalculatorException.from(CalculatorErrorMessage.NOT_NUMBER_ERROR);
        }
    }
}