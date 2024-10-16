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
        if (inputData == null || inputData.isEmpty()) {
            return separatedData;
        }

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
        if (inputData == null || inputData.isEmpty()) {
            return separatedData;
        }

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

}
