package calculator.service.util;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.CalculatorErrorMessage;
import calculator.dto.request.CalculatorRequest;
import java.util.ArrayList;
import java.util.List;

public final class InputParser {
    public static List<Integer> parseByDelimiters(CalculatorRequest request) {
        String targetInput = request.targetInput();
        String delimiters = request.delimiters();

        if (targetInput.isEmpty()) {
            return new ArrayList<>();
        }

        String[] tokens = splitByDelimiters(targetInput, delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = parseToInt(token);
            numbers.add(number);
        }

        return numbers;
    }

    private static String[] splitByDelimiters(String targetInput, String delimiters) {
        return targetInput.split(delimiters);
    }

    private static int parseToInt(String numberString) {
        try {
            return Integer.parseInt(numberString.trim());
        } catch (NumberFormatException e) {
            throw CalculatorException.from(CalculatorErrorMessage.NOT_NUMBER_ERROR);
        }
    }
}