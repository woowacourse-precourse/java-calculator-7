package calculator.service;

public enum Separators {
    COMMA(","), COLON(";");

    private String separator;

    Separators(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
