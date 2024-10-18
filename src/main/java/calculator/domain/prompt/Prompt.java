package calculator.domain.prompt;

import calculator.global.utility.CharacterUtils;
import java.util.Collections;
import java.util.List;

public abstract class Prompt {

    protected final Delimiter delimiter;
    private final List<String> input;

    protected Prompt(String inputData) {
        this.delimiter = new Delimiter();
        this.input = parseInput(inputData);
    }

    protected abstract List<String> parseInput(String inputData);
    protected abstract List<String> separate(String inputData);

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
