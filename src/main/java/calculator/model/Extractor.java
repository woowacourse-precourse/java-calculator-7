package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extractor {
    private static final String CUSTOM_IDENTIFIER_PREFIX = "//";
    private static final String CUSTOM_IDENTIFIER_SUFFIX = "\\n";

    public List<Integer> extractNumbers(String input, String... delimiters) {
        String customDelimiter = findCustomDelimiter(input);
        if (customDelimiter != null) {
            String cleanedInput = removeIdentifier(input);
            String[] byCustom = cleanedInput.split(customDelimiter);
            return parseStringToInt(byCustom);
        }

        String regex = createRegex(delimiters);
        String[] byDefault = input.split(regex);
        return parseStringToInt(byDefault);
    }

    private String findCustomDelimiter(String input) {
        int prefixIndex = CUSTOM_IDENTIFIER_PREFIX.length();
        int suffixIndex = input.indexOf(CUSTOM_IDENTIFIER_SUFFIX);

        // 커스텀 구분자를 사용하지 않으면 null 리턴
        if (suffixIndex == -1) {
            return null;
        }

        return input.substring(prefixIndex, suffixIndex);
    }

    private String removeIdentifier(String input) {
        if (input.startsWith(CUSTOM_IDENTIFIER_PREFIX)) {
            int suffixIndex = input.indexOf(CUSTOM_IDENTIFIER_SUFFIX);
            if (suffixIndex != -1) {
                return input.substring(suffixIndex + CUSTOM_IDENTIFIER_SUFFIX.length());
            }
        }

        return input;
    }

    private List<Integer> parseStringToInt(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    private String createRegex(String[] delimiters) {
        String regex = "[";
        for (String delimiter : delimiters) {
            regex += delimiter;
        }
        regex += "]";
        return regex;
    }
}
