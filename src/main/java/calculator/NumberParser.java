package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();
    private static final int CUSTOM_SUFFIX_LENGTH = CUSTOM_SUFFIX.length();

    public List<Integer> parse(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        String[] numbers = split(input);
        return convertToIntegerList(numbers);
    }

    private String[] split(String input) {
        if (hasCustomDelimiter(input)) {
            return splitCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_PREFIX);
    }

    private String[] splitCustomDelimiter(String input) {
        int index = input.indexOf(CUSTOM_SUFFIX);
        String customDelimiter = input.substring(CUSTOM_PREFIX_LENGTH, index);
        String result = input.substring(index + CUSTOM_SUFFIX_LENGTH);
        return result.split(customDelimiter);
    }

    private List<Integer> convertToIntegerList(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            NumberValidator.validate(number);
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
