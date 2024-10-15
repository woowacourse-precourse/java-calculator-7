package calculator.extractor;

import calculator.number.Numbers;
import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    private static final List<String> DEFAULT_DELIMITERS = java.util.List.of(",", ":");

    private final CustomDelimiterCalculator customDelimiterCalculator = new CustomDelimiterCalculator();
    private final List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

    public Numbers extract(String str) {
        if (customDelimiterCalculator.hasCustomDelimiter(str)) {
            addCustomDelimiter(str);
            str = customDelimiterCalculator.removeCustomDelimiterPrefix(str);
        }

        List<String> strNumbers = splitByDelimiters(str);
        return Numbers.of(strNumbers);
    }

    private void addCustomDelimiter(String str) {
        String customDelimiter = customDelimiterCalculator.extractCustomDelimiterFrom(str);
        delimiters.add(customDelimiter);
    }

    private List<String> splitByDelimiters(String str) {
        String regex = getRegex();
        return List.of(str.split(regex));
    }

    private String getRegex() {
        String joinedDelimiters = String.join("", delimiters);
        return String.format("[%s]", joinedDelimiters);
    }
}
