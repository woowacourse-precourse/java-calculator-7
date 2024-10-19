package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterParser {
    private final DelimiterManager delimiterManager;

    public DelimiterParser(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    public List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();

        String[] parts = splitByDelimiters(input);

        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }

        return numbers;
    }

    public String parseCustomDelimiter(String input) {
        int index = input.indexOf("\n");
        return input.substring(2, index);
    }

    public String removeCustomDelimiter(String input) {
        int index = input.indexOf("\n");

        if (index != -1) {
            return input.substring(index + 1);
        }

        return input;
    }

    private String[] splitByDelimiters(String input) {
        String regex = buildDelimiterRegex();
        return input.split(regex);
    }

    private String buildDelimiterRegex() {
        StringBuilder regexBuilder = new StringBuilder();

        for (String delimiter : DelimiterManager.defaultDelimiters) {
            if (regexBuilder.length() > 0) {
                regexBuilder.append("|");
            }
            regexBuilder.append(delimiter);
        }

        for (String delimiter : DelimiterManager.customDelimiters) {
            regexBuilder.append("|").append(delimiter);
        }

        return regexBuilder.toString();
    }
}
