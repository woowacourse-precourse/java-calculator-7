package calculator.model.dto;

public class DelimiterInputData {
    public static Character COMMA = ',';
    public static Character COLON = ':';

    private final Character customedDelimiter;

    private final String input;

    public DelimiterInputData(Character customedDelimiter, String input) {
        this.customedDelimiter = customedDelimiter;
        this.input = input;
    }

    public Character getcustomedDelimiter() {
        return customedDelimiter;
    }

    public String getInput() {
        return input;
    }
}
