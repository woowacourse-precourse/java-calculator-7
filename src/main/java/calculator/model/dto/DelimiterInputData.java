package calculator.model.dto;

public class DelimiterInputData {
    public static Character COMMA = ',';
    public static Character COLON = ':';

    private final Character customDelimiter;

    private final String input;

    public DelimiterInputData(Character customDelimiter, String input) {
        this.customDelimiter = customDelimiter;
        this.input = input;
    }

    public Character getcustomDelimiter() {
        return customDelimiter;
    }

    public String getInput() {
        return input;
    }
}
