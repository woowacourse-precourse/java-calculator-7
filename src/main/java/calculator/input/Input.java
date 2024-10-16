package calculator.input;

public class Input {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    private final String nums;

    protected Input(String nums) {
        this.nums = nums;
    }

    public static Input of(String input) {
        return InputFilter.from(input);
    }

    public boolean isSeparatorEqual(char ch) {
        return ch == SEPARATOR_COLON || ch == SEPARATOR_COMMA;
    }

    public String getNums() {
        return nums;
    }
}
