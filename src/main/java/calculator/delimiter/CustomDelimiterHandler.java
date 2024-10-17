package calculator.delimiter;

public class CustomDelimiterHandler implements DelimiterHandler {

    @Override
    public String getNumbersWithDelimiter(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

}
