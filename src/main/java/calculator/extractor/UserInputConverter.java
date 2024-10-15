package calculator.extractor;

import java.util.ArrayList;
import java.util.List;

public class UserInputConverter {
    private static final List<String> DEFAULT_DELIMITERS = java.util.List.of(",", ":");

    private final CustomDelimiterCalculator customDelimiterCalculator = new CustomDelimiterCalculator();
    private final List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

    public List<String> split(String str) {
        if (customDelimiterCalculator.hasCustomDelimiter(str)) {
            addCustomDelimiter(str);
            str = customDelimiterCalculator.removeCustomDelimiterPrefix(str);
        }

        return List.of(splitByDelimiters(str));
    }

    private void addCustomDelimiter(String str) {
        String customDelimiter = customDelimiterCalculator.extractCustomDelimiterFrom(str);
        delimiters.add(customDelimiter);
    }

    private String[] splitByDelimiters(String str) {
        String regex = getRegex();
        return str.split(regex);
    }

    private String getRegex() {
        String joinedDelimiters = String.join("", delimiters);
        return String.format("[%s]", joinedDelimiters);
    }
}
