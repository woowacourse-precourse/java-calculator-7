package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private static final String DEFAULT_SEPARATOR_COMMA = ",";
    private static final String DEFAULT_SEPARATOR_COLON = ":";
    private List<String> separators;
    private CustomSeparatorHandler customSeparatorHandler;

    public Separator() {
        this.separators = new ArrayList<>(Arrays.asList(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON));
        this.customSeparatorHandler = new CustomSeparatorHandler();
    }

    public String[] splitByAllSeparators(String input) {
        String customSeparator = customSeparatorHandler.extractCustomSeparator(input);
        addCustomSeparator(customSeparator);

        String cleanedInput = customSeparatorHandler.removeCustomSeparatorDefinition(input);

        String regex = createSeparatorRegex(separators);
        return cleanedInput.split(regex);
    }

    private void addCustomSeparator(String customSeparator) {
        if (customSeparator != null) {
            separators.add(customSeparator);
        }
    }

    private String createSeparatorRegex(List<String> allSeparators) {
        String separatorPattern = allSeparators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return "(" + separatorPattern + ")";
    }
}
