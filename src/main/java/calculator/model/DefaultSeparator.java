package calculator.model;

import calculator.validator.DefaultSeparatorValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultSeparator {
    private final List<String> defaultSeparators;

    public DefaultSeparator() {
        this.defaultSeparators = new ArrayList<>();
        setInitialValue();
    } // DefaultSeparator

    private void setInitialValue() {
        defaultSeparators.add(",");
        defaultSeparators.add(":");
    } // addInitialValue

    public List<Integer> separate(String input) {
        new DefaultSeparatorValidator().validate(defaultSeparators, input);

        String numbers = defaultSeparators.stream()
                .reduce(input, (result, defaultSeparator) -> result.replaceAll(defaultSeparator, " "));

        return Arrays.stream(numbers.split(" "))
                .map(number -> number.isEmpty() ? "0" : number)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    } // separate
} // class