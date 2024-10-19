package calculator.model.Dto;

public class DelimiterInputData {
    public static Character COMMA = ',';
    public static Character COLON = ':';

    private Character customedDelimiter;

    private String input;

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
