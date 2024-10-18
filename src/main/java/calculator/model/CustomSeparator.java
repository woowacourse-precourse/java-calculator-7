package calculator.model;

import calculator.validator.CustomSeparatorValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSeparator {
    private final List<String> customSeparators;

    public CustomSeparator() {
        customSeparators = new ArrayList<>();
    } // customSeparator

    public List<Integer> separate(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            addAll(Arrays.asList(matcher.group(1).split("")));
        } // end if

        List<String> numbers = customSeparators.stream()
                .map(customSeparator -> matcher.group(2).replaceAll(customSeparator, " "))
                .toList();

        return numbers.stream()
                .map(number -> number.isEmpty() ? "0" : number)
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    } // separate

    public void addAll(List<String> separator) {
        new CustomSeparatorValidator().validate(separator);
        customSeparators.addAll(separator);
    } // addAll
} // class