package calculator.service;

import calculator.model.CalculationRequestDTO;
import calculator.model.DelimiterExtractionResult;
import calculator.model.DelimiterExtractor;

public class CalculatorService {
    public static int calculate(CalculationRequestDTO requestDTO) {
        String input = requestDTO.getInput();

        DelimiterExtractionResult extractionResult = DelimiterExtractor.extractDelimiterAndNumbers(input);
        String delimiter = extractionResult.getDelimiter();
        String numbers = extractionResult.getNumbers();

        return sumNumbers(numbers, delimiter);
    }

    private static int sumNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += myParseInt(number);
        }
        return sum;
    }

    private static int myParseInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }
}