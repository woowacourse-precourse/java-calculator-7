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

    public static CalcTarget registCustomSeparator(String value, String customSeparator) {
        CalcTarget calcTarget = new CalcTarget(value);
        calcTarget.customSeparator = customSeparator;
        return calcTarget;
    }

    public String getValue() {
        return value;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }
}
