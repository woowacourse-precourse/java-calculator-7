package calculator.separator.domain;

public class Separator {
    private final String customSeparator;
    public Separator(String customSeparator) {
        this.customSeparator = customSeparator;
    }
    public String getSeparator() {
        return customSeparator;
    }
}
