package calculator.service.impl;

import static calculator.common.DelimiterConstant.*;

import calculator.model.Operand;
import calculator.service.ExtractorService;
import calculator.service.ValidatorService;
import java.util.regex.Pattern;

public class ExtractorServiceImpl implements ExtractorService {

    private final ValidatorService validatorService;

    public ExtractorServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public Operand extract(String input) {
        int delimiterEndIndex;
        String expression;
        switch (validatorService.validateInput(input)) {
            case DEFAULT_DELIMITERS_STATUS:
                validatorService.validateDelimiterExpression(DEFAULT_DELIMITERS, input);
                return Operand.create(DEFAULT_DELIMITERS, input);
            case EMPTY_CUSTOM_DELIMITER_STATUS:
                delimiterEndIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
                expression = input.substring(delimiterEndIndex + 2);
                validatorService.validateDelimiterExpression(DEFAULT_DELIMITERS, expression);
                return Operand.create(DEFAULT_DELIMITERS, expression);
            case CUSTOM_DELIMITER_STATUS:
                delimiterEndIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
                expression = input.substring(delimiterEndIndex + 2);
                String customDelimiter = extractCustomDelimiter(input);
                validatorService.validateDelimiterExpression(customDelimiter, expression);
                return Operand.create(customDelimiter, expression);
            default:
                throw new Error("Unexpected Input format: " + input);
        }
    }

    protected String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = input.substring(2, delimiterEndIndex);
        String[] delimitersArray = customDelimiter.split("");
        StringBuilder delimiterPattern = new StringBuilder();
        for (String delimiter : delimitersArray) {
            delimiterPattern.append(Pattern.quote(delimiter)).append("|");
        }
        delimiterPattern.append(DEFAULT_DELIMITERS);
        return delimiterPattern.toString();
    }
}
