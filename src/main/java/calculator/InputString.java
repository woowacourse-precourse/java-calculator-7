package calculator;

public class InputString {
    private final String inputString;

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

    public InputString substring(int beginIndex) {
        return new InputString(inputString.substring(beginIndex));
    }

    public String[] split(String regex) {
        return inputString.split(regex);
    }
}
