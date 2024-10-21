package calculator.model;

public class ParsedInput {

    private final String delimiterRegex;
    private final String numbersWithDelimiter;

    public ParsedInput(String delimiterRegex, String numbersWithDelimiter) {
        this.delimiterRegex = delimiterRegex;
        this.numbersWithDelimiter = numbersWithDelimiter;
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }

    public String getNumbersWithDelimiter() {
        return numbersWithDelimiter;
    }
}
