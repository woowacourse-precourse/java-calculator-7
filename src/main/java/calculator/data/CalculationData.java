package calculator.data;

public class CalculationData {
    private final String valueString;
    private final String delimiterPattern;

    public CalculationData(String valueString, String delimiterPattern) {
        this.valueString = valueString;
        this.delimiterPattern = delimiterPattern;
    }

    public String getValueString() {
        return valueString;
    }

    public String getDelimiterPattern() {
        return delimiterPattern;
    }
}
