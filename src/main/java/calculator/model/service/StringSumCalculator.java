package calculator.model.service;

import static calculator.common.CalculatorConstant.DEFAULT_VALUE;

import calculator.model.implement.DelimiterManager;
import calculator.model.implement.StringParser;
import calculator.model.domain.CustomNumber;
import java.util.List;

public class StringSumCalculator implements Calculator {

    private final DelimiterManager delimiterManager;
    private final StringParser stringParser;

    public StringSumCalculator(DelimiterManager delimiterManager, StringParser stringParser) {
        this.delimiterManager = delimiterManager;
        this.stringParser = stringParser;
    }

    @Override
    public int calculate(String inputValue) {
        if (inputValue.isEmpty()) {
            return DEFAULT_VALUE;
        }

        String targetValue = inputValue;
        if (delimiterManager.existCustomDelimiter(inputValue)) {
            delimiterManager.registerCustomDelimiters(inputValue);
            targetValue = stringParser.splitTarget(inputValue);
        }
        List<CustomNumber> extractedNumbers = stringParser.parseToNumbers(targetValue);

        return extractedNumbers.stream()
                .mapToInt(CustomNumber::getNumber)
                .sum();
    }
}
