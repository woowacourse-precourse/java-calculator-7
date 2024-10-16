package calculator.service;

public class DelimiterService {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public String[] splitNumbers(String input) {
        return splitByDefaultDelimiters(input);
    }

    private String[] splitByDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

}