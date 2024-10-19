package calculator.domain;

import calculator.utility.CharacterUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prompt {

    private static final String CUSTOM_DELIMITER_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR_SUFFIX = "\\\\n";
    private static final int EXPECTED_SEPARATE_LENGTH = 2;

    private final Delimiter delimiter;
    private final List<String> input;

    public Prompt(String inputData) {
        this.delimiter = new Delimiter();
        this.input = parseInput(inputData);
    }

    protected List<String> parseInput(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return new ArrayList<>();
        }

        return determineAndSeparate(inputData.split(CUSTOM_DELIMITER_SEPARATOR_SUFFIX), inputData);
    }

    private List<String> determineAndSeparate(String[] splitData, String inputData) {
        validateParse(splitData);

        if (splitData[0].startsWith(CUSTOM_DELIMITER_SEPARATOR_PREFIX)) {
            this.delimiter.add(inputData.charAt(2));
            return this.separate(splitData[1]);
        }

        return this.separate(splitData[0]);
    }

    private void validateParse(String[] splitData) {
        if (splitData.length > EXPECTED_SEPARATE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    protected List<String> separate(String inputData) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char word: inputData.toCharArray()) {
            if (this.delimiter.isIn(word)) {
                separatedData.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(word);
        }
        separatedData.add(stringBuilder.toString());

        return separatedData;
    }

    public List<Integer> extractInteger() {
        return this.getInput()
                .stream()
                .map(this::parseNumber)
                .toList();
    }

    private Integer parseNumber(String data) {
        validateNumber(data);
        return Integer.valueOf(data);
    }

    private void validateNumber(String data) {
        validateNotNullOrEmpty(data);
        validateOnlyDigits(data);
    }

    private void validateOnlyDigits(String data) {
        for (char word: data.toCharArray()) {
            if (CharacterUtils.isNotDigit(word)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNotNullOrEmpty(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getInput() {
        return Collections.unmodifiableList(input);
    }

}
