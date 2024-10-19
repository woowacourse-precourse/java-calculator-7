package calculator;

public class Delimiter {
    public static final int DELIMITER_START_INDEX = 2;
    public static final String DEFAULT_DELIMITER = "[,:]";
    private final String delimiter;

    public Delimiter(String inputString) {
        delimiter = validateCustomDelimiter(inputString);
    }

    private String validateCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            for (int i = DELIMITER_START_INDEX; i < input.length(); i++) {
                if (input.startsWith("\\n", i)) {
                    return input.substring(DELIMITER_START_INDEX, i);
                }
            }
        }
        return DEFAULT_DELIMITER;
    }

    public String get() {
        return delimiter;
    }
}
