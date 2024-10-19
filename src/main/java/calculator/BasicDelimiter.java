package calculator;

public class BasicDelimiter implements Delimiter {
    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String[] split(String input){
        return input.split(DEFAULT_DELIMITER);
    }
}
