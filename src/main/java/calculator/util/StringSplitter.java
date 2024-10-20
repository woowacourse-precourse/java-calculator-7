package calculator.util;

public class StringSplitter {
    private static final String DEFAULT_SPLITTER = "[,:]";

    private StringSplitter() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] splitUserInput(String userInput) {
        return userInput.split(DEFAULT_SPLITTER);
    }
}
