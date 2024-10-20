package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy{
    private String delimiters = ",|:";
    @Override
    public String[] split(String input) {
        return input.split(delimiters);
    }
}
