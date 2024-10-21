package calculator.service;

import calculator.model.CustomSeparators;
import calculator.model.DefaultSeparators;
import calculator.model.Separators;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.Message.*;

public class SeparatorsService {
    public static final int SEPARATOR_PART = 1;
    public static final int CALCULATE_PART = 2;
    private final Pattern pattern = Pattern.compile(CUSTOM_SEPARATE_REGEX);
    private Matcher matcher;

    public Separators createSeparator(String input) {
        if (containsCustomSeparator(input)) {
            String separatePart = getSeparatePart(input);
            List<String> inputCustomSeparators = Arrays.stream(separatePart.split(EMPTY)).toList();
            return new CustomSeparators(inputCustomSeparators);
        } // end if

        return new DefaultSeparators();
    } // createSeparator

    public String getSeparatePart(String input) {
        matcher = pattern.matcher(input);
        String separatePart = EMPTY;

        if (matcher.find()) {
            separatePart = matcher.group(SEPARATOR_PART);
        } // end if

        return separatePart;
    } // getSeparatePart

    public String getCalculatePart(String input) {
        matcher = pattern.matcher(input);
        String calculatePart = EMPTY;

        if (matcher.find()) {
            calculatePart = matcher.group(CALCULATE_PART);
        } // end if

        return calculatePart;
    } // getCalculatePart

    private boolean containsCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATE_REGEX);
    } // containsCustomSeparator
} // class