package calculator;

public class StringSplitter {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        return input.split(DEFAULT_DELIMITERS);
    }
}
