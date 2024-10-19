package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorPrompt {

    private static final String CUSTOM_DELIMITER_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR_SUFFIX = "\\\\n";
    private static final int EXPECTED_SEPARATE_LENGTH = 2;

    private final Delimiter delimiter;
    private final List<String> data;

    public CalculatorPrompt(String command) {
        this.delimiter = new Delimiter();
        this.data = parseInput(command);
    }

    protected List<String> parseInput(String command) {
        if (command == null || command.isEmpty()) {
            return new ArrayList<>();
        }

        return determineAndSeparate(command.split(CUSTOM_DELIMITER_SEPARATOR_SUFFIX), command);
    }

    private List<String> determineAndSeparate(String[] splitData, String command) {
        validateParse(splitData);

        if (splitData[0].startsWith(CUSTOM_DELIMITER_SEPARATOR_PREFIX)) {
            this.delimiter.add(command.charAt(2));
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

        for (char word : inputData.toCharArray()) {
            if (delimiter.isIn(word)) {
                separatedData.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(word);
        }
        separatedData.add(stringBuilder.toString());

        return separatedData;
    }

    public List<String> getData() {
        return Collections.unmodifiableList(data);
    }

}
