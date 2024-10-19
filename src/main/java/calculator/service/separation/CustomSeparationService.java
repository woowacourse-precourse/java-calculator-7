package calculator.service.separation;

import static calculator.service.exception.SeparationExceptionType.NOT_EXIST_CUSTOM_SEPARATOR;
import static calculator.service.validation.SeparationValidator.validate;

import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.service.exception.SeparationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSeparationService implements SeparationService {

    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_POSTFIX = "\\n";

    @Override
    public boolean hasCustomSeparator(String input) {
        return input.contains(CUSTOM_SEPARATOR_PREFIX) && input.contains(CUSTOM_SEPARATOR_POSTFIX);
    }

    @Override
    public Numbers getNumbers(String input, String... separators) {
        String inputWithoutNotation = removeNotation(input);
        String customSeparator = extractCustomSeparator(input);

        validate(inputWithoutNotation, customSeparator);

        String[] split = split(inputWithoutNotation, customSeparator);
        List<Number> values = Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::from)
                .collect(Collectors.toList());

        return Numbers.from(values);
    }

    private String extractCustomSeparator(String input) {
        int prefixIndex = input.indexOf(CUSTOM_SEPARATOR_PREFIX);
        int postfixIndex = input.indexOf(CUSTOM_SEPARATOR_POSTFIX);

        String customSeparator = input.substring(prefixIndex + 2, postfixIndex);
        if (customSeparator.isBlank()) {
            throw new SeparationException(NOT_EXIST_CUSTOM_SEPARATOR);
        }
        return customSeparator;
    }

    private String removeNotation(String input) {
        int postfixIndex = input.indexOf(CUSTOM_SEPARATOR_POSTFIX);
        return input.substring(postfixIndex + 2);
    }
}
