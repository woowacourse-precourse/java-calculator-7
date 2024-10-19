package calculator.service;

import calculator.util.ArrayConverter;
import calculator.util.ExtractUtil;
import calculator.util.NumberValidator;
import java.util.Arrays;

public class CalculatorService {
    private final ExtractUtil extractUtil;
    private final NumberValidator numberValidator;
    private final ArrayConverter arrayConverter;

    public CalculatorService() {
        this.extractUtil = new ExtractUtil();
        this.numberValidator = new NumberValidator();
        this.arrayConverter = new ArrayConverter(numberValidator);
    }

    public int processCalculator(String readInput) {
        String customDelimiter = extractUtil.extractCustomDelimiter(readInput);
        String positiveString = extractUtil.extractPositiveString(readInput, customDelimiter);

        char[] positiveCharacters = arrayConverter.toCharArrayWithoutDelimiter(positiveString, customDelimiter);
        int[] positives = arrayConverter.convertCharArrayToIntArray(positiveCharacters);

        numberValidator.validateNoNegatives(positives); // 양수 검사
        return calculatorNumbers(positives);
    }

    private int calculatorNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}