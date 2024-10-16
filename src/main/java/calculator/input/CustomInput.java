package calculator.input;

public class CustomInput extends Input {

    private final char separator;

    public CustomInput(String nums, char separator) {
        super(nums);
        this.separator = separator;
    }

    public char getSeparator() {
        return separator;
    }

    @Override
    protected boolean isSeparator(char ch) {
        return ch == separator;
    }
}
