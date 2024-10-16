package calculator.model;

public class Delimiter {

    private final String delimiter;

    public Delimiter(String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public void validate(String delimiter) {
        if (!isChar(delimiter) || isNumber(delimiter)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isChar(String string) {
        return string.length() < 2;
    }

    private boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
