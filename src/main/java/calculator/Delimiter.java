package calculator;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    CUSTOM_DOUBLE_SLASH("//");

    private final String stringDelimiter;

    Delimiter(String delimiter) {
        this.stringDelimiter = delimiter;
    }

    public String getDelimiter() {
        return stringDelimiter;
    }

    public static Delimiter fromDelimiter(String value) {
        for (Delimiter delimiter : values()) {
            if (delimiter.getDelimiter().equals(value)) {
                return delimiter;
            }
        }
        return null; // 또는 예외를 던질 수 있음
    }
}
