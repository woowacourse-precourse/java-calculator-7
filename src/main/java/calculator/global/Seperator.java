package calculator.global;

public enum Seperator {

    COMMA(","),
    COLON(":"),
    CUSTOM(null);

    private String seperator;

    Seperator(String seperator) {
        this.seperator = seperator;
    }

    public String getSeperator() {
        return this.seperator;
    }

    public void updateCustomSeperator(String newSeperator) {
        if (this == CUSTOM) {
            this.seperator = newSeperator;
        }
    }
}
