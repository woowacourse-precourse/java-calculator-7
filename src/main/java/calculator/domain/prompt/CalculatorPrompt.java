package calculator.domain.prompt;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPrompt extends Prompt {

    public CalculatorPrompt(String input) {
        super(input);
    }

    public CalculatorPrompt(String input, char customDelimiter) {
        super(input, customDelimiter);
    }

    @Override
    protected List<String> separate(String inputData) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char word: inputData.toCharArray()) {
            if (word == DELIMITER_COMMA || word == DELIMITER_COLON) {
                separatedData.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(word);
        }
        separatedData.add(stringBuilder.toString());

        return separatedData;
    }

    @Override
    protected List<String> separate(String inputData, char customDelimiter) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char word: inputData.toCharArray()) {
            if (word == DELIMITER_COMMA || word == DELIMITER_COLON || word == customDelimiter) {
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

}
