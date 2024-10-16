package calculator.input;

public class CustomInput extends Input {

    private final char separator;

    public CustomInput(String nums, char separator) {
        super(nums);
        this.separator = separator;
    }

    @Override
    public boolean isSeparatorEqual(char ch) {
        return ch == separator;
    }
}
