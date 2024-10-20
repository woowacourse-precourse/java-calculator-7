package calculator;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS = ",:";

    public String[] split(String input) {
        return input.split("[" + DEFAULT_DELIMITERS + "]",-1);
    }
}
