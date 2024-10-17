package calculator.input;

public class CustomInput extends Input {

    private final char separator;

    protected CustomInput(String numStr, char separator) {
        super(numStr);
        this.separator = separator;
    }

    @Override
    public boolean matchesSeparator(char ch) {
        return ch == this.separator;
    }
}
