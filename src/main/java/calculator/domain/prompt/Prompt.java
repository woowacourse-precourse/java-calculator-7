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

    public List<String> getInput() {
        return Collections.unmodifiableList(input);
    }

}
