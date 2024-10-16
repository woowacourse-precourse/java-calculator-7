package calculator;

public class Calculator {
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_DELIMITER_INPUT_INDEX = 5;

    private static String input;
    private static String delimiters;

    public static void run(String inputValue) {
        setInput(inputValue);
        setDelimiter();
    }

    private static void setInput(String inputValue) {
        input = inputValue;
    }

    private static void setDelimiter() {
        if (input.startsWith("//") && input.startsWith("\\n", CUSTOM_DELIMITER_END_INDEX)) {
            delimiters = "[,:" + input.charAt(CUSTOM_DELIMITER_INDEX) + "]";
            input = input.substring(CUSTOM_DELIMITER_INPUT_INDEX);
            return;
        }
        delimiters = "[,:]";
    }
}
