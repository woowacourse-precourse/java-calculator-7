package calculator.model;

import calculator.validator.CustomSeparatorValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSeparator {
    private final List<String> customSeparator;

    public CustomSeparator() {
        customSeparator = new ArrayList<>();
    } // customSeparator

    public List<Integer> separate(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            addAll(Arrays.asList(matcher.group(1).split("")));
        }

        String numbers = customSeparator.stream()
                .reduce(matcher.group(2), (result, separator) -> result.replaceAll(separator, " "));

        return Arrays.stream(numbers.split(" "))
                .map(number -> number.isEmpty() ? "0" : number)
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    } // separate

    public void addAll(List<String> separator) {
        new CustomSeparatorValidator().validate(separator);
        customSeparator.addAll(separator);
    } // addAll
} // class