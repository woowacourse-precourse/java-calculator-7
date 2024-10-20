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
    private List<String> separators;
    private final List<Integer> numbersForSum;

    public Data(String firstInputData) {
        this.firstInputData = firstInputData;
        separators = new ArrayList<>();
        numbersForSum = handleInputString();
    }

    public int calculateAddition() {
        int sum = 0;
        for (int number : numbersForSum) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> handleInputString() {
        if (hasEmptyString()) {
            numbersForSum.add(0);
            return numbersForSum;
        }
        separators = handleSeparator();
        String[] extractedStrings = removeSeparator(separators, firstInputData);
        return NumberValidator.convertNumbers(extractedStrings);
    }

    private List<String> handleSeparator() {
        separators.add(SEPARATOR_COLON);
        separators.add(SEPARATOR_COMMA);
        separators.addAll(extractCustomSeparator());
        return separators;
    }

    public List<String> extractCustomSeparator() {
        List<String> customSeparator = new ArrayList<>();
        if (containsCustomSeparator(firstInputData)) {
            customSeparator.add(firstInputData.substring(CUSTOM_START_LETTERS.length(),
                    firstInputData.indexOf(CUSTOM_END_LETTERS)));
            removeCustomSeparatorFormat();
        }
        return customSeparator;
    }

    public String[] removeSeparator() {
        String str = inputData;
        String[] separatedString = separateString(separators, str);

        for (String string : separatedString) {
            if (hasInvalidSeparatorFormat(string)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SEPARATOR);
            }
        }
        return separatedString;
    }

    private boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }

    private String removeCustomSeparatorFormat() {
        return firstInputData.substring(firstInputData.indexOf(CUSTOM_END_LETTERS) + CUSTOM_END_LETTERS.length());
    }

    private String[] separateString(List<String> separators, String inputData) {
        StringBuilder splitFormat = new StringBuilder();
        for (int i = 0; i < separators.size(); i++) {
            splitFormat.append(separators.get(i));
            if (i < separators.size() - 1) {
                splitFormat.append(MAKE_SPLIT_FORMAT_LETTER);
            }
        }
        return inputData.split(splitFormat.toString());
    }

    private boolean hasEmptyString() {
        return firstInputData.equals(EMPTY_STRING);
    }
}
