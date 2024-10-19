package calculator.model;

import calculator.validator.DefaultSeparatorsValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.constant.Message.*;

public class DefaultSeparators implements Separators {
    private final List<String> defaultSeparators;

    public DefaultSeparators() {
        this.defaultSeparators = new ArrayList<>();
        setInitialValue();
    } // DefaultSeparators

    private void setInitialValue() {
        defaultSeparators.add(FIRST_DEFAULT_SEPARATOR);
        defaultSeparators.add(SECOND_DEFAULT_SEPARATOR);
    } // addInitialValue

    @Override
    public List<Integer> separateNumbers(String input) {
        new DefaultSeparatorsValidator().validate(input);

        String numbers = defaultSeparators.stream()
                .reduce(input, (result, defaultSeparator) -> result.replaceAll(defaultSeparator, WHITE_SPACE));

        return Arrays.stream(numbers.split(WHITE_SPACE))
                .map(number -> number.isEmpty() ? DEFAULT_VALUE_STR : number)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    } // separate
} // class