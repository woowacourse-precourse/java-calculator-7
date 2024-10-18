package calculator.domain;

public class DefaultDelimiter implements Delimiter {

    private static final String NUMBER_REGEX = "[0-9]+([,|:][0-9]+)*";
    private static final String DELIMITER_REGEX = "[,:]";

    @Override
    public boolean supports(String input) {
        return input.matches(NUMBER_REGEX);
    }

    @Override
    public String[] split(String input) {
        return input.split(DELIMITER_REGEX);
    }
}
