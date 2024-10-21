package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService implements Service {

    private static final String CUSTOM_SEPARATOR_REGEX = "^//\\D\n";

    @Override
    public List<String> createSeparators() {
        List<String> separators = new ArrayList<>();
        for (Separators separator : Separators.values()) {
            separators.add(separator.getSeparator());
        }
        return separators;
    }

    @Override
    public boolean isCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATOR_REGEX);
    }

    @Override
    public String checkCustomSeparator(String input) {
        String regex = "^//\\D\n";
        if (input.matches(regex)) {

        }
        return input;
    }

    @Override
    public String removeCustomPart(String input) {
        return "";
    }

    @Override
    public String[] separateInput(String input, List<String> separators) {
        return new String[0];
    }

    @Override
    public int calculate(String[] nums) {
        return 0;
    }
}
