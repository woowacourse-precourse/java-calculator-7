package calculator.delimiter.impl;

import calculator.delimiter.Delimiter;

public class CustomDelimiter implements Delimiter {
    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean isApplicable() {
        return !delimiter.isEmpty();
    }
}
