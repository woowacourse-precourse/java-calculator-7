package calculator.domain.dto;

import java.util.ArrayList;

public class DelimiterParserResult {

    private final ArrayList delimiters;
    private final String removedString;

    public DelimiterParserResult(ArrayList delimiters, String removedString) {
        this.delimiters = delimiters;
        this.removedString = removedString;
    }

    public ArrayList getDelimiters() {
        return delimiters;
    }

    public String getRemovedString() {
        return removedString;
    }
}
