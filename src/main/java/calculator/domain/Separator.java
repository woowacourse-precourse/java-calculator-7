package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String DEFAULT_COMMA = ",";
    private static final String DEFAULT_COLON = ":";
    private final List<String> availableSeparators;
    private final List<Integer> extractedNumbers;

    public Separator(String numbers) {
        availableSeparators = new ArrayList<>(List.of(DEFAULT_COMMA, DEFAULT_COLON));
        extractedNumbers = new ArrayList<>();
        validate(numbers);
    }
    private void validate(String numbers) {
        if(numbers.startsWith("//")) {
            int newlineIndex = validateSpecialCase(numbers);
            numbers = addCustomSeparator(numbers, newlineIndex);
        }
        validateSeparators(numbers);
    }
    private int validateSpecialCase(String numbers) {
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

        return newlineIndex;
    }

    private String addCustomSeparator(String numbers, int newlineIndex) {
        String customSeparator = numbers.substring(2, newlineIndex);
        availableSeparators.add(customSeparator);
        return numbers.substring(newlineIndex+2);
    }

    private void validateSeparators(String numbers) {
        for(char ch : numbers.toCharArray()) {
            if(!Character.isDigit(ch) && !availableSeparators.contains(String.valueOf(ch))) {
                throw new IllegalArgumentException();
            }
        }
        extractNumbers(numbers);
    }

    private void extractNumbers(String numbers) {
        for(char ch : numbers.toCharArray()) {
            if(Character.isDigit(ch)) {
                extractedNumbers.add(Character.getNumericValue(ch));
            }
        }
    }

    public List<Integer> getExtractedNumbers() {
        return extractedNumbers;
    }
}
