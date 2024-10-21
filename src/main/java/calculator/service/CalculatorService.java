package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService implements Service {

    private static final String CUSTOM_SEPARATOR_START_REGEX = "^//";

    private static final String CUSTOM_SEPARATOR_END_REGEX = "\n";

    private final List<String> separators = new ArrayList<>();


    @Override
    public void createSeparators() {
        for (Separators separator : Separators.values()) {
            separators.add(separator.getSeparator());
        }
    }

    @Override
    public boolean isCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATOR_START_REGEX + "\\D" + CUSTOM_SEPARATOR_END_REGEX);
    }

    @Override
    public void saveCustomSeparator(String input) {
        int endRegexIndex = input.indexOf(CUSTOM_SEPARATOR_END_REGEX);
        separators.add(String.valueOf(input.charAt(endRegexIndex - 1)));
    }

    @Override
    public String removeCustomPart(String input) {
        return "";
    }

    @Override
    public String[] separateInput(String input) {
        return new String[0];
    }

    @Override
    public int calculate(String[] nums) {
        return 0;
    }
}
