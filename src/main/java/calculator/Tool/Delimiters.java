package calculator.Tool;

public enum Delimiters {
    COMMA(","),
    COLON(";"),
    CUSTOM("//(.*?)\\\\n");
    private final String delimiter;

    Delimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public static String getDelimiters() {
        StringBuilder result = new StringBuilder();
        for (Delimiters delimiter : Delimiters.values()) {
            if (result.length() > 0) {
                result.append("|");
            }
            result.append(delimiter.delimiter);
        }
        return result.toString();
    }
}
