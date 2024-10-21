package calculator;

public class StringSplitter {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private static StringSplitter instance;

    private StringSplitter() {}

    public static StringSplitter getInstance() {
        if (instance == null) {
            instance = new StringSplitter();
        }
        return instance;
    }

    public String[] split(String input) {
        String delimiter = DELIMITER;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            checkNoCustomDelimiter(delimiterIndex);
            delimiter = String.valueOf(input.charAt(2));
            delimiter = escapeSpecialRegexChars(delimiter);
            input = input.substring(delimiterIndex + CUSTOM_DELIMITER_SUFFIX.length());
        }

        return input.split("[" + delimiter + "]");
    }

    private void checkNoCustomDelimiter(int delimiterIndex) {
        if (delimiterIndex == 2) {
            throw new IllegalArgumentException("커스텀 구분자가 지정되지 않았습니다");
        }
    }

    private String escapeSpecialRegexChars(String delimiter) {
        if (delimiter.matches("\\d+") || delimiter.matches("\\s+")) {
            throw new IllegalArgumentException("구분자는 문자와 기호만 포함할 수 있습니다: " + delimiter);
        }
        return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\|.])", "\\\\$1");
    }
}
