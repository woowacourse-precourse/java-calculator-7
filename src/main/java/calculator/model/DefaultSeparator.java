package calculator.model;

import calculator.validator.DefaultSeparatorValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.constant.Message.*;

public class DefaultSeparator {
    private final List<String> defaultSeparators;

    public DefaultSeparator() {
        this.defaultSeparators = new ArrayList<>();
        setInitialValue();
    } // DefaultSeparator

    private void setInitialValue() {
        defaultSeparators.add(FIRST_DEFAULT_SEPARATOR);
        defaultSeparators.add(SECOND_DEFAULT_SEPARATOR);
    } // addInitialValue

    public List<Integer> separate(String input) {
        new DefaultSeparatorValidator().validate(input);

        String numbers = defaultSeparators.stream()
                .reduce(input, (result, defaultSeparator) -> result.replaceAll(defaultSeparator, WHITE_SPACE));

        return Arrays.stream(numbers.split(WHITE_SPACE))
                .map(number -> number.isEmpty() ? DEFAULT_VALUE_STR : number)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    } // separate
} // class