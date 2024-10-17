package calculator.model;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.utils.RegexUtils;

public class Extractor {
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";
    private static final int NOT_FOUND_END = -1;
    private static final int NOT_FOUND_DELIMITER = 2;
    private static final int START_DELIMITER = 2;
    private static final int CUSTOM_END_SIZE = 2;

    public void execute(String input, Storage storage) {
        while (input.startsWith(CUSTOM_START)) {
            int nextStartIdx = findCustomDelimiter(input, storage);
            input = deleteCustomDelimiters(input, nextStartIdx);
        }
        extractIntegers(input, storage);
    }

    private void extractIntegers(String input, Storage storage) {
        String regex = RegexUtils.makeAllOfDelimiters(storage.getAllowedDelimiters());
        for (String candidate : input.split(regex)) {
            storage.addCandidateOfNumber(candidate);
        }
    }

    private int findCustomDelimiter(String input, Storage storage) {
        int customEndIdx = input.indexOf(CUSTOM_END);
        if (customEndIdx == NOT_FOUND_END || customEndIdx == NOT_FOUND_DELIMITER) {
            throw new IllegalArgumentException();
        }
        storage.addCustomDelimiter(makeCustomDelimiter(input, customEndIdx));
        return customEndIdx + CUSTOM_END_SIZE;
    }

    private String deleteCustomDelimiters(String input, int nextStartIdx) {
        return input.substring(nextStartIdx);
    }

    private CustomDelimiter makeCustomDelimiter(String input, int customEndIdx) {
        return new CustomDelimiter(input.substring(START_DELIMITER, customEndIdx));
    }
}
