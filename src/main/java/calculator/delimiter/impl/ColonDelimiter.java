package calculator.delimiter.impl;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DefaultDelimiter;

public class ColonDelimiter implements Delimiter {
    private final String delimiter;

    public ColonDelimiter() {
        this.delimiter = DefaultDelimiter.COLON.getDelimiter();
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
