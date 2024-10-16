package calculator.delimiter;

public class Delimiter {
    private String del;
    private static final int CUSTOM_DEL_INDEX = 2;
    private static final String DEFAULT_DELIMITER = ",:";

    public Delimiter() {
        this.del = "[" + DEFAULT_DELIMITER + "]";
    }

    public String getDel() {
        return del;
    }

    public String addCustomDelimiter(String input) {
        DelimiterValidator.validateInputLength(input);

        String customDelHeader = getCustomDelHeader(input);
        DelimiterValidator.validateCustomDelHeader(customDelHeader);

        char customDel = extractCustomDel(customDelHeader);
        DelimiterValidator.validateCustomDel(customDel, DEFAULT_DELIMITER);

        updateDel(customDel);
        return removeCustomDelHeader(input);
    }

    private static char extractCustomDel(String customDelHeader) {
        return customDelHeader.charAt(CUSTOM_DEL_INDEX);
    }


    private String getCustomDelHeader(String input) {
        return input.substring(0, 5);
    }


    private static String removeCustomDelHeader(String input) {
        return input.length() == 5 ? "" : input.substring(5);
    }

    private void updateDel(char customDel) {
        String escapeDel = DelimiterValidator.escapeSpecialCharacters(customDel);
        this.del = "[" + DEFAULT_DELIMITER + escapeDel + "]";
    }
}
