package calculator.service;

public class Command {

    private final Separator customSeparator;
    private final String expression;

    public Command(Separator customSeparator, String expression) {
        this.customSeparator = customSeparator;
        this.expression = expression;
    }

    public boolean hasCustomSeparator() {
        return customSeparator != null;
    }

    public Separator getCustomSeparator() {
        return customSeparator;
    }

    public String getExpression() {
        return expression;
    }
}
