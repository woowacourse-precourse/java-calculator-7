package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";
    private static final String MAKE_SPLIT_FORMAT_LETTER = "|";
    private static final String EMPTY_STRING = "";
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";
    private final String firstInputData;
    private final List<Integer> numbersForSum;
    private String removedSeparatorInput;
    private List<String> separators;

    public Data(String firstInputData) {
        this.firstInputData = firstInputData;
        separators = new ArrayList<>();
        numbersForSum = handleInput();
    }

    public int calculateAddition() {
        int sum = 0;
        for (int number : numbersForSum) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> handleInput() {
        if (hasEmptyString()) {
            numbersForSum.add(0);
            return numbersForSum;
        }
        separators = handleSeparator();
        String[] extractedStrings = removeSeparator();
        return NumberValidator.convertNumbers(extractedStrings);
    }

    private List<String> handleSeparator() {
        separators.add(SEPARATOR_COLON);
        separators.add(SEPARATOR_COMMA);
        separators.addAll(extractCustomSeparator());
        return separators;
    }

    private List<String> extractCustomSeparator() {
        List<String> customSeparator = new ArrayList<>();
        if (containsCustomSeparator(firstInputData)) {
            customSeparator.add(firstInputData.substring(CUSTOM_START_LETTERS.length(),
                    firstInputData.indexOf(CUSTOM_END_LETTERS)));
            removedSeparatorInput = removeCustomSeparatorFormat();
        }
        return customSeparator;
    }

    private boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }

    private String removeCustomSeparatorFormat() {
        return firstInputData.substring(firstInputData.indexOf(CUSTOM_END_LETTERS) + CUSTOM_END_LETTERS.length());
    }


    private String[] removeSeparator() {
        StringBuilder splitFormat = new StringBuilder();
        for (int i = 0; i < separators.size(); i++) {
            splitFormat.append(separators.get(i));
            if (i < separators.size() - 1) {
                splitFormat.append(MAKE_SPLIT_FORMAT_LETTER);
            }
        }
        return removedSeparatorInput.split(splitFormat.toString());
    }

    private boolean hasEmptyString() {
        return firstInputData.equals(EMPTY_STRING);
    }
}
