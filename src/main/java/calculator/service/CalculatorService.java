package calculator.service;

import calculator.util.ArrayConverter;
import calculator.util.ExtractUtil;
import calculator.util.NumberValidator;
import java.util.Arrays;

public class CalculatorService {
    private final ExtractUtil extractUtil;
    private final ArrayConverter arrayConverter;
    private final NumberValidator numberValidator;

    public CalculatorService() {
        this.extractUtil = new ExtractUtil();
        this.arrayConverter = new ArrayConverter();
        this.numberValidator = new NumberValidator();
    }

    public int processCalculator(String readInput) {
        String customDelimiter = extractUtil.extractCustomDelimiter(readInput);
        String positiveString = extractUtil.extractPositiveString(readInput, customDelimiter);

        char[] positiveCharacters = arrayConverter.toCharArrayWithoutDelimiter(positiveString, customDelimiter);
        numberValidator.validateNoDigits(positiveCharacters); // 숫자 변환 가능한 문자 검사

        int[] positives = arrayConverter.convertCharArrayToIntArray(positiveCharacters);
        numberValidator.validatorNoNegatives(positives); // 양수 검사

        return calculatorNumbers(positives);
    }

    private int calculatorNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}