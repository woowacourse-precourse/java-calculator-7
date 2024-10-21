package calculator;

public class NumberToken {
    private final double value;

    public NumberToken(String tokenStr, boolean decimalAllowed) {
        if (tokenStr.isEmpty()) {
            value = 0;
            return;
        }
        if (!isNumeric(tokenStr, decimalAllowed)) {
            throw new IllegalArgumentException("Invalid number: " + tokenStr);
        }
        value = parseValue(tokenStr);
        validateValue();
    }

    private boolean isNumeric(String str, boolean decimalAllowed) {
        boolean hasDecimalPoint = false;
        for (char c : str.toCharArray()) {
            if (c == '.') {
                if (!decimalAllowed || hasDecimalPoint) {
                    return false;
                }
                hasDecimalPoint = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private double parseValue(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + str);
        }
    }

    private void validateValue() {
        if (value < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + value);
        }
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid number: " + value);
        }
        if (value > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Number too large: " + value);
        }
    }
    public double getValue() {
        return value;
    }
}
