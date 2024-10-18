package calculator.delimiter.service;

import calculator.common.exception.ExceptionFactory;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.util.pattern.PatternUtils;

import java.util.ArrayList;
import java.util.List;

import static calculator.common.exception.ExceptionType.NOT_DELIMITER;

public class NumberDelimiterService extends DelimiterService {

    public NumberDelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {

        super(delimiterFactory, customDelimiterService);
    }

    @Override
    public List<String> splitByDelimiters(String value) {
        Delimiters delimiters = getDelimiters(value);
        String strippedInput = customDelimiterService.stripCustomDelimiter(value);

        validateStrippedInput(strippedInput, delimiters);

        return new ArrayList<>(List.of(strippedInput.split(delimiters.splitRegex())));
    }

    private void validateStrippedInput(String strippedInput, Delimiters delimiters) {
        if (!PatternUtils.matchesWithDelimitersIgnoringNumbers(strippedInput, delimiters.pattern())) {
            throw ExceptionFactory.createException(NOT_DELIMITER);
        }
    }
}
