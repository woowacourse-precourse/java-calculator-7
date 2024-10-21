package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService implements Service {

    @Override
    public List<String> createSeparators() {
        List<String> separators = new ArrayList<>();
        for (Separators separator : Separators.values()) {
            separators.add(separator.getSeparator());
        }
        return separators;
    }

    @Override
    public String checkCustomSeparator(String input) {
        return "";
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
