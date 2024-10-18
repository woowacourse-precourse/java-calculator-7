package calculator.model;

import calculator.validator.CustomSeparatorValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.Message.*;

public class CustomSeparator {
    public static final int SEPARATOR_PART = 1;
    public static final int CALCULATE_PART = 2;
    private final List<String> customSeparators;

    public CustomSeparator() {
        customSeparators = new ArrayList<>();
    } // customSeparator

    public List<Integer> separate(String input) {
        String calculatePart = separateCalculatePart(input);

        String numbers = customSeparators.stream()
                .reduce(calculatePart, (result, customSeparator) -> result.replaceAll(customSeparator, WHITE_SPACE));

        return Arrays.stream(numbers.split(WHITE_SPACE))
                .map(number -> number.isEmpty() ? DEFAULT_VALUE_STR : number)
                .mapToInt(Integer::parseInt).boxed()
                .toList();
    } // separate

    public String separateCalculatePart(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATE_REGEX);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            addAll(Arrays.asList(matcher.group(SEPARATOR_PART).split(EMPTY)));
        } // end if

        return matcher.group(CALCULATE_PART);
    } // separatePart

    public void addAll(List<String> separator) {
        new CustomSeparatorValidator().validate(separator);
        customSeparators.addAll(separator);
    } // addAll
} // class