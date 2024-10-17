package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {

    private static final String BLANK = "";
    private static final String DEFAULT_SEPARATOR_COMMA = ",";
    private static final String DEFAULT_SEPARATOR_COLON = ":";
    private static final String CUSTOM_SEPARATOR_DEFINITION_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_DEFINITION_SUFFIX = "\n";
    private static List<String> separators = Arrays.asList(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON);

    public List<Integer> extractNumbers(String input) {
        if (isBlank(input)) {
            return Collections.singletonList(0);
        }

        String customSeparator = extractCustomSeparator(input);
        String numberString = removeCustomSeparatorDefinition(input);
        List<String> allSeparators = getAllSeparators(customSeparator);
        String[] numberStrings = splitByAllSeparators(numberString, allSeparators);

        return convertToNumbers(numberStrings);
    }

    private List<String> getAllSeparators(String customSeparator) {
        List<String> allSeparators = new ArrayList<>(separators);
        if (customSeparator != null) {
            allSeparators.add(customSeparator);
        }
        return allSeparators;
    }

    public String[] splitByAllSeparators(String input, List<String> allSeparators) {
        String regex = createSeparatorRegex(allSeparators);
        return input.split(regex);
    }

    private String createSeparatorRegex(List<String> allSeparators) {
        String separatorPattern = allSeparators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return "(" + separatorPattern + ")";
    }

    private List<Integer> convertToNumbers(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }

    public boolean isBlank(String input) {
        return input.equals(BLANK);
    }

    public String extractCustomSeparator(String input) {
        int endIndex = findCustomSeparatorEndIndex(input);
        if (endIndex == -1) {
            return null;
        }
        return input.substring(CUSTOM_SEPARATOR_DEFINITION_PREFIX.length(), endIndex);
    }

    public String removeCustomSeparatorDefinition(String input) {
        int endIndex = findCustomSeparatorEndIndex(input);
        if (endIndex == -1) {
            return input;
        }
        return input.substring(endIndex + CUSTOM_SEPARATOR_DEFINITION_SUFFIX.length());
    }

    private int findCustomSeparatorEndIndex(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_DEFINITION_PREFIX)) {
            return -1;
        }
        int endIndex = input.indexOf(CUSTOM_SEPARATOR_DEFINITION_SUFFIX);
        if (endIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        return endIndex;
    }
}
