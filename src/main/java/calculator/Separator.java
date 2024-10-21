package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private ArrayList<String> separators = new ArrayList<>(List.of(",", ":"));

    public String addCustomParser(String input) {
        if (input.startsWith("//")) {
            return processCustomSeparator(input);
        }
        return input;
    }

    private String processCustomSeparator(String input) {
        int limitIndex = findLimitIndex(input);

        String customSeparator = extractCustomSeparator(input, limitIndex);
        validateCustomSeparator(customSeparator);
        addSeparator(customSeparator);

        return extractProcessedString(input, limitIndex);
    }

    private int findLimitIndex(String input) {
        int limitIndex = input.indexOf("\\n");
        if (limitIndex == -1) {
            throw new IllegalArgumentException();
        }
        return limitIndex;
    }

    private String extractCustomSeparator(String input, int limitIndex) {
        return input.substring(2, limitIndex);
    }

    private void validateCustomSeparator(String customSeparator) {
        if (containsDigit(customSeparator)) {
            throw new IllegalArgumentException();
        }
    }

    private void addSeparator(String customSeparator) {
        if (!customSeparator.isEmpty()) {
            separators.add(customSeparator);
        }
    }

    private String extractProcessedString(String input, int limitIndex) {
        return input.substring(limitIndex + 2);
    }

    public String createDelimiterRegex() {
        return separators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
