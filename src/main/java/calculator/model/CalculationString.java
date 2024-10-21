package calculator.model;

public class CalculationString {

    private final String inputString;
    private static final String DEFAULT_ZERO = "0";

    public CalculationString(String inputString) {
        this.inputString = inputString;
    }

    public String getString() {
        if (isEmptyOrBlank(inputString)) {
            return DEFAULT_ZERO;
        }
        return inputString;
    }

    private boolean isEmptyOrBlank(String rawString) {
        return rawString.isBlank() || rawString.isEmpty();
    }
}
