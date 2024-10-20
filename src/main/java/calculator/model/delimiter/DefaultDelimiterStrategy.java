package calculator.model.delimiter;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    private static final String DEFAULT_DELIMITERS = ",|:";

    @Override
    public String[] getStringArray(String input) {

        String[] numberArray = input.split(DEFAULT_DELIMITERS, -1);
        return checkDuplicatedDelimiters(numberArray);
    }
}