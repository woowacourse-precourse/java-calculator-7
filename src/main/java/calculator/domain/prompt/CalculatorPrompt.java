package calculator.domain.prompt;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPrompt extends Prompt {

    public CalculatorPrompt(String input) {
        super(input);
    }

    @Override
    protected List<String> parseInput(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return new ArrayList<>();
        }

        String[] splitData = inputData.split("\\\\n");
        validateParse(splitData);

        return determineAndSeparate(splitData, inputData);
    }

    private List<String> determineAndSeparate(String[] splitData, String inputData) {
        if (splitData[0].startsWith("//")) {
            return this.separate(splitData[1], inputData.charAt(2));
        }
        return this.separate(splitData[0], '\0'); // 커스텀 구분자가 없는 경우
    }

    private void validateParse(String[] splitData) {
        if (splitData.length > 2) {
            throw new IllegalArgumentException();
        }
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

}
