package calculator.model;

public enum RegularExpression {
    CUSTOM_LINE("^//(.*)\\\\n(.*)"),
    NUMBER_LINE("^(?://(.+?)\\\\n)?(.*)");

    private final String regularExpression;

    RegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }
}
