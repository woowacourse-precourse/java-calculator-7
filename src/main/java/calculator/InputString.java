package calculator;

public class InputString {
    private String inputString;

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public boolean isBlank() {
        return inputString.isBlank();
    }

    public boolean containsCustomSeperator() {
        return inputString.startsWith("//") && inputString.startsWith("\\n", 3);
    }

    public char extractCustomSeperator() {
        return inputString.charAt(2);
    }
}
