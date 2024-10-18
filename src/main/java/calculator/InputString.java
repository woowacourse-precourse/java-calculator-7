package calculator;

public class InputString {
    private String inputString;

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public boolean isBlank() {
        return inputString.isBlank();
    }
}
