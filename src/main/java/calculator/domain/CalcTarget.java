package calculator.domain;

public class CalcTarget {

    private String value;
    private String customSeparator;

    public CalcTarget() {}

    public CalcTarget(String value) {
        this.value = value;
    }

    public static CalcTarget input(String value) {
        return new CalcTarget(value);
    }

    public void registCustomSeparator(String value, String customSeparator) {
        this.value = value;
        this.customSeparator = customSeparator;
    }

    public String getValue() {
        return value;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }
}
