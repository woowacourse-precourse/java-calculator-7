package calculator.Utils;

public class NumberValidator {

    public boolean isInt(String value) {
        try {
            Integer.parseUnsignedInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isLong(String value) {
        try {
            Long.parseUnsignedLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
