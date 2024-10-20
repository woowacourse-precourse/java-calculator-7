package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class InputData {
    private static final String EMPTY_STRING = "";
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";
    private final String firstInputData;
    private List<String> separators;
    private String[] extractedStrings;
    private List<Integer> numbersForSum;

    public InputData(String firstInputData) {
        this.firstInputData = firstInputData;
        separators = new ArrayList<>();
        separators.add(SEPARATOR_COLON);
        separators.add(SEPARATOR_COMMA);
        numbersForSum = new ArrayList<>();
    }

    private List<Integer> handleInputString() {
        if (hasEmptyString()) {
            numbersForSum.add(0);
            return numbersForSum;
        }
        separators = SeparatorValidator.extractCustomSeparator(separators, firstInputData);
    }

    private boolean hasEmptyString() {
        return firstInputData.equals(EMPTY_STRING);
    }
}
