package calculator.entity;

public class Input {

    private String input;

    public Input(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input should not be null");
        }
        this.input = input;
    }
}
