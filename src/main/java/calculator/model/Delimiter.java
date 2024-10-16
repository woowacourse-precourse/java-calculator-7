package calculator.model;

public class Delimiter {

    private final String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public Delimiter validate() {
        if (isChar(this.delimiter) && !isNumber(this.delimiter)) {
            return this;
        }
        throw new IllegalArgumentException();
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
