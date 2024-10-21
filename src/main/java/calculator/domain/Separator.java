package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Separator {

    private static final String CUSTOM_DELIMITER_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR_SUFFIX = "\\\\n";
    private static final int DEFAULT_DATA_SPLIT_LENGTH = 1;
    private static final int CUSTOM_DATA_SPLIT_LENGTH = 2;
    private static final int CUSTOM_DELIMITER_STRING_LENGTH = 3;

    private final Delimiter delimiter;
    private final StringBuilder buffer;
    private final List<String> result;

    public Separator() {
        this.delimiter = new Delimiter();
        this.buffer = new StringBuilder();
        this.result = new ArrayList<>();
    }

    public void separate(String data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        String[] splitData = data.split(CUSTOM_DELIMITER_SEPARATOR_SUFFIX);
        validateSplitDataLength(splitData);
        handleDelimiterAndSplit(data, splitData);
    }

    private void handleDelimiterAndSplit(String data, String[] splitData) {
        switch (splitData.length) {
            case DEFAULT_DATA_SPLIT_LENGTH -> this.separateByDelimiter(splitData[0]);
            case CUSTOM_DATA_SPLIT_LENGTH -> customDataSeparate(data, splitData);
            default -> throw new IllegalArgumentException();
        }
    }

    private void customDataSeparate(String data, String[] splitData) {
        validateCustomDelimiter(splitData[0]);

        this.delimiter.add(data.charAt(2));
        this.separateByDelimiter(splitData[1]);
    }

    private void separateByDelimiter(String data) {
        this.result.clear();

        for (char word : data.toCharArray()) {
            appendOrSeparate(word);
        }
        addBufferToResult();
    }

    private void appendOrSeparate(char word) {
        if (this.delimiter.isIn(word)) {
            addBufferToResult();
            return;
        }

        this.buffer.append(word);
    }

    private void addBufferToResult() {
        this.result.add(this.buffer.toString());
        this.buffer.setLength(0);
    }

    private void validateSplitDataLength(String[] splitData) {
        if (splitData.length > CUSTOM_DATA_SPLIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCustomDelimiter(String customDelimiterString) {
        if (isInvalidCustomDelimiter(customDelimiterString) ) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidCustomDelimiter(String customDelimiterString) {
        return !customDelimiterString.startsWith(CUSTOM_DELIMITER_SEPARATOR_PREFIX) ||
                customDelimiterString.length() != CUSTOM_DELIMITER_STRING_LENGTH;
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(this.result);
    }

}
