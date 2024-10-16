package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String DEFAULT_COMMA = ",";
    private static final String DEFAULT_COLON = ":";
    private final List<String> availableSeparators;

    public Separator(String numbers) {
        availableSeparators = new ArrayList<>(List.of(DEFAULT_COMMA, DEFAULT_COLON));
        validate(numbers);
    }

    private void validate(String numbers) {
        if(numbers.startsWith("//")) {
            int newlineIndex;
            if(numbers.contains("\\n")) {
                newlineIndex = numbers.indexOf("\\n");
            }
            else {
                newlineIndex = numbers.indexOf("\n");
            }

            if(newlineIndex == -1) {
                throw new IllegalArgumentException();
            }

            String customSeparator = numbers.substring(2, newlineIndex);
            availableSeparators.add(customSeparator);

            numbers = numbers.substring(newlineIndex+2);
        }
        for(char ch : numbers.toCharArray()) {
            if(!Character.isDigit(ch) && !availableSeparators.contains(String.valueOf(ch))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getAvailableSeparators() {
        return availableSeparators;
    }
}
