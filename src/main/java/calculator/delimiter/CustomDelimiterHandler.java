package calculator.delimiter;

public class CustomDelimiterHandler implements DelimiterHandler {

    private DelimiterChecker delimiterChecker;

    public CustomDelimiterHandler(DelimiterChecker delimiterChecker) {
        this.delimiterChecker = delimiterChecker;
    }

    @Override
    public String getNumbersWithDelimiter(String input) {
        return input.substring(input.indexOf(delimiterChecker.getSuffix()) + 1);
    }

}
