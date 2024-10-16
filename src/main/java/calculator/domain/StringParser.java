package calculator.domain;

public class StringParser {

    private final static int INITIAL_NUMBER = 0;
    private final static int FIRST_NUMBER = 1;

    private final String inputStrings;

    public StringParser(final String inputStrings) {
        this.inputStrings = inputStrings;
    }

    private String paresFirstString() {
        return inputStrings.substring(INITIAL_NUMBER, FIRST_NUMBER);
    }
}
