package calculator.domain;

import calculator.validator.CalculatorValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final int DECLARE_PART_LENGTH = 4;
    private static final int CUSTOM_SEPARATOR_INDEX = 2;

    private final CalculatorValidator calculatorValidator;

    public Calculator(CalculatorValidator calculatorValidator) {
        this.calculatorValidator = calculatorValidator;
    }

    public int sumInteger(List<Integer> parsedIntegers) {
        int sumOfIntegers = 0;
        for (int i : parsedIntegers) {
            sumOfIntegers += i;
        }
        return sumOfIntegers;
    }

    public List<Integer> parseStringToInteger(String[] removedSeparatorsArray) {
        List<Integer> parsedIntegers = new ArrayList<>();
        for (String number : removedSeparatorsArray) {
            if (!number.isEmpty()) {
                calculatorValidator.validateNumberFormat(number);
                int num = Integer.parseInt(number.trim());

                calculatorValidator.validateNonNegative(num);
                parsedIntegers.add(num);
            }
        }
        return parsedIntegers;
    }

    public String[] removeSeparators(String removedDeclarePart, Character customSeparator) {
        String regex;
        if (customSeparator == null) {
            regex = "[,:]";
        } else {
            regex = "[,:" + Pattern.quote(customSeparator.toString()) + "]";
        }

        return removedDeclarePart.split(regex);
    }

    public String removeDeclarePart(String input, Character customSeparator) {
        if (customSeparator == null) {
            return input;
        }
        else {
            return input.substring(DECLARE_PART_LENGTH);
        }
    }

    public Character extractCustomSeparator(String input) {
        calculatorValidator.validateSeparator(input);

        if (!input.startsWith("//")) {
            return null;
        }
        return input.charAt(CUSTOM_SEPARATOR_INDEX);
    }
}
