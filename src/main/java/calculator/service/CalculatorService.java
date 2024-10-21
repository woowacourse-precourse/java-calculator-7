package calculator.service;

import static calculator.service.CustomSeparatorsRegex.END_REGEX;
import static calculator.service.CustomSeparatorsRegex.END_SEPARATOR;
import static calculator.service.CustomSeparatorsRegex.MIDDLE_REGEX;
import static calculator.service.CustomSeparatorsRegex.START_REGEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorService implements Service {

    private final List<String> separators = new ArrayList<>();


    @Override
    public void createSeparators() {
        for (Separators separator : Separators.values()) {
            separators.add(separator.getSeparator());
        }
    }

    @Override
    public boolean isCustomSeparator(String input) {
        boolean result = input.matches(START_REGEX.getRegex()) && input.matches(END_REGEX.getRegex());
        return result;
    }

    @Override
    public void saveCustomSeparator(String input) {
        int endRegexIndex = input.indexOf(END_SEPARATOR.getRegex());
        separators.add(String.valueOf(input.charAt(endRegexIndex - 1)));
    }

    @Override
    public String removeCustomPart(String input) {
        return input.replaceAll(
                START_REGEX.getRegex() + MIDDLE_REGEX.getRegex() + END_REGEX.getRegex(), "");
    }

    @Override
    public String[] separateInput(String input) {
        String separatorsRegex = "[" + String.join("", separators) + "]";
        return input.split(separatorsRegex);
    }

    @Override
    public int calculate(String[] nums) {
        return Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
    }
}
