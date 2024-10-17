package calculator;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int NOT_FOUND = -1;
    private static final String CUSTOM_DELIMITER_FRONT = "//";
    private static final String CUSTOM_DELIMITER_BACK = "\\n";
    private static String ERROR_MESSAGE = "잘못된 구분자 형식입니다.";

    public Delimiter() {
    }

    public String[] split(String token) {
        String delimiterRegex = DEFAULT_DELIMITER;
        if (containCustomDelimiter(token)) {
            String customDelimiter = getDelimiter(token);
            delimiterRegex = addDelimiter(customDelimiter);
            token = removeCustomDelimiterPattern(token);
        }

        return token.split(delimiterRegex);
    }

    private String addDelimiter(String delimiter) {
        return DEFAULT_DELIMITER + "|" + delimiter;
    }

    private boolean containCustomDelimiter(String token) {
        int start = token.indexOf(CUSTOM_DELIMITER_FRONT);
        if (start == NOT_FOUND) {
            return false;
        }

        int end = token.indexOf(CUSTOM_DELIMITER_BACK, start);
        return end != NOT_FOUND;
    }

    private String getDelimiter(String token) {
        int indexStart = token.indexOf(CUSTOM_DELIMITER_FRONT);
        int start = indexStart + CUSTOM_DELIMITER_FRONT.length();
        int end = token.indexOf(CUSTOM_DELIMITER_BACK, start);
        if (end == NOT_FOUND) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (end - start != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return token.substring(start, end);
    }

    private String removeCustomDelimiterPattern(String token) {
        int indexStart = token.indexOf(CUSTOM_DELIMITER_FRONT);
        int indexEnd = token.indexOf(CUSTOM_DELIMITER_BACK, indexStart);
        if (indexEnd == NOT_FOUND) {
            throw new IllegalArgumentException(ERROR_MESSAGE
            );
        }

        return token.substring(0, indexStart) +
                token.substring(indexEnd + CUSTOM_DELIMITER_BACK.length());
    }
}
