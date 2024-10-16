package calculator.domain.prompt;

import java.util.Collections;
import java.util.List;

public abstract class Prompt {

    protected static final char DELIMITER_COMMA = ',';
    protected static final char DELIMITER_COLON = ':';

    private final List<String> input;

    protected Prompt(String inputData) {
        this.input = this.separate(inputData);
    }

    protected Prompt(String inputData, char customDelimiter) {
        this.input = this.separate(inputData, customDelimiter);
    }

    protected abstract List<String> separate(String inputData);
    protected abstract List<String> separate(String inputData, char customDelimiter);

    public List<Integer> extractInteger() {
        List<String> separatedData = this.getInput();

        return separatedData.stream()
                .map(data -> {
                    validateNumber(data);
                    return Integer.valueOf(data);
                })
                .toList();
    }

    private void validateNumber(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (char word: data.toCharArray()) {
            if (this.isNotDigit(word)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isNotDigit(char word) {
        return !Character.isDigit(word);
    }

    public List<String> getInput() {
        return Collections.unmodifiableList(input);
    }

}
