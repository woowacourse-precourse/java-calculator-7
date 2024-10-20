package calculator.delimiter.impl;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DefaultDelimiter;

public class CommaDelimiter implements Delimiter {
    private final String delimiter;

    public CommaDelimiter() {
        this.delimiter = DefaultDelimiter.COMMA.getDelimiter();
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean isApplicable() {
        return true;
    }
}
