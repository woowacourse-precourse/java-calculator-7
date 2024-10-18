package calculator.domain.prompt;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPrompt extends Prompt {

    private static final String CUSTOM_DELIMITER_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR_SUFFIX = "\\\\n";
    private static final int EXPECTED_SEPARATE_LENGTH = 2;

    public CalculatorPrompt(String input) {
        super(input);
    }

    @Override
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

    @Override
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

}
