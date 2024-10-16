package calculator.dto;

import java.util.Optional;

public class CSFResult {
    private final Optional<Character> customSeparator;
    private final String result;
    public CSFResult(Optional<Character> customSeparator, String result) {
        this.customSeparator = customSeparator;
        this.result = result;
    }

    public Optional<Character> getCustomSeparator() {
        return customSeparator;
    }

    public String getResult() {
        return result;
    }
}
