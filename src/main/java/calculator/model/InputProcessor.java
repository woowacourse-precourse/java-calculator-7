package calculator.model;

public class InputProcessor {

    private String input;
    //public static final D

    public InputProcessor(String input) {
        this.input = input;
    }

    public boolean isDefaultCase() {
        return Character.isDigit(input.charAt(0));
    }

    public boolean isCustomCase() {
        return input.startsWith("//");
    }

}
