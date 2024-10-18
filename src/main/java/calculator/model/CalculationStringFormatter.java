package calculator.model;

public class CalculationStringFormatter {

    private String customDelimiter = "";
    private String expression = "";

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public String getExpression() {
        return expression;
    }

    public void resolveCalculationString(String inputString) {
        if (inputString.startsWith("//") && inputString.contains("\n")) {
            resolveCustomDelimiter(inputString);
            expression = inputString.substring(inputString.indexOf("\n") + 2);
        } else if (isBasicCalculationString(inputString)) {
            expression = inputString;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void resolveCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\n");

        customDelimiter = input.substring(startIndex, endIndex);
    }

    private boolean isBasicCalculationString(String input) {
        return Character.isDigit(input.charAt(0)) && Character.isDigit(
            input.charAt(input.length() - 1));
    }
}
