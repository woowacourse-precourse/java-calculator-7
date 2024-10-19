package calculator.model;

import java.util.Arrays;
import java.util.List;

public final class CalculatorModel {

    public boolean isCustom(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public List<String> parseUserInput(String input) {
        if (isCustom(input)) {

        }

        return parseDefaultString(input);
    }

    public List<String> parseDefaultString(String input) {
        return Arrays.asList(input.split("[,;]"));
    }
}
