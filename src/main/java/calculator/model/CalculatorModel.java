package calculator.model;

import java.util.Arrays;
import java.util.List;

public final class CalculatorModel {

    public boolean isCustom(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public List<String> parseUserInput(String input) {
        if (isCustom(input)) {
            return parseCustomString(input);
        }

        return parseDefaultString(input);
    }

    public List<String> parseCustomString(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        String delimiter = input.substring(2, delimiterEndIndex);
        String numbersPart = input.substring(delimiterEndIndex + 1);

        return Arrays.asList(numbersPart.split(delimiter));
    }

    public List<String> parseDefaultString(String input) {
        return Arrays.asList(input.split("[,;]"));
    }
}
