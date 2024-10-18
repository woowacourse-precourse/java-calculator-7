package calculator.model;

import calculator.util.NumberValidator;

import java.util.Arrays;

public class NumberFinder {
    private final DelimiterManager delimiterManager;

    private final NumberValidator numberValidator;

    public NumberFinder(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
        this.numberValidator = NumberValidator.getInstance();
    }

    public int[] findNumbersFrom(String ridiculousSentenceIncludeNumber) {
        String correct = delimiterManager.removeCustomDelimiterFrom(ridiculousSentenceIncludeNumber);
        String regex = delimiterManager.buildRegex();
        String[] maybeNums = correct.split(regex);
        numberValidator.isValid(maybeNums);
        return convertToIntegerArray(maybeNums);
    }

    private int[] convertToIntegerArray(String[] maybeNums) {
        return Arrays.stream(maybeNums)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
