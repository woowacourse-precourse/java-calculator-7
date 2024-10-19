package calculator;

public class InputParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private String customDelimiter;

    public String parseCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            extractCustomDelimiter(input);
            input = input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
        }
        return input;
    }

    private void extractCustomDelimiter(String input) {
        customDelimiter = input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }

    public int[] parseInteger(String input) {
        int[] numbers = new int[input.length()];
        String[] stringNumbers = input.split(DEFAULT_DELIMITERS + "|" + customDelimiter); // TODO 작동 하는지 확인
//        String[] stringNumbers = input.split(DEFAULT_DELIMITERS);

        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    public static boolean isDelimiter(String input) { // TODO

        return true;
    }
}
