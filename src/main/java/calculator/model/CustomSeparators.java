package calculator.model;

import calculator.validator.CustomSeparatorsValidator;

import java.util.Arrays;
import java.util.List;

import static calculator.constant.Message.DEFAULT_VALUE_STR;
import static calculator.constant.Message.WHITE_SPACE;

public class CustomSeparators implements Separators {
    private final List<String> customSeparators;

    public CustomSeparators(List<String> customSeparators) {
        new CustomSeparatorsValidator().validate(customSeparators);
        this.customSeparators = customSeparators;
    } // CustomSeparators

    @Override
    public List<Integer> separateNumbers(String calculatePart) {
        new CustomSeparatorsValidator().validateCalculatePart(customSeparators, calculatePart);

        String numbers = customSeparators.stream()
                .reduce(calculatePart, (result, customSeparator) -> result.replaceAll(customSeparator, WHITE_SPACE));

        return Arrays.stream(numbers.split(WHITE_SPACE))
                .map(number -> number.isEmpty() ? DEFAULT_VALUE_STR : number)
                .mapToInt(Integer::parseInt).boxed()
                .toList();
    } // separate
} // class