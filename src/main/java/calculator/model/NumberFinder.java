package calculator.model;

import calculator.util.StringArrayValidator;
import calculator.util.Validator;

import java.util.Arrays;

public class NumberFinder {
    private final DelimiterManager delimiterManager;

    private final Validator<String[]> numberValidator;

    public NumberFinder(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
        this.numberValidator = StringArrayValidator.getInstance();
    }

    public int[] findNumbersFrom(String ridiculousSentenceIncludeNumber) {
        String numericStringWithDelimiter = delimiterManager.removeCustomDelimiterFrom(ridiculousSentenceIncludeNumber);
        String regex = delimiterManager.buildRegex();
        String[] numericString = numericStringWithDelimiter.split(regex);
        numberValidator.isValid(numericString);
        return convertToIntegerArray(numericString);
    }

    private int[] convertToIntegerArray(String[] maybeNums) {
        return Arrays.stream(maybeNums)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}