package calculator.service;

import calculator.model.CalculationRequestDTO;
import calculator.model.DelimiterExtractionResult;
import calculator.model.DelimiterExtractor;

public class CalculatorService {
    public static int calculate(CalculationRequestDTO requestDTO) {
        String input = requestDTO.getInput();
        if (isNullOrEmpty(input)) {
            return 0;
        }

        DelimiterExtractionResult extractionResult = DelimiterExtractor.extractDelimiterAndNumbers(input);
        String delimiter = extractionResult.getDelimiter();
        String numbers = extractionResult.getNumbers();

        return sumNumbers(numbers, delimiter);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sumNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += parsePositiveInt(number);
        }
        return sum;
    }

    private static int parsePositiveInt(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식입니다: " + number);
        }
    }
}