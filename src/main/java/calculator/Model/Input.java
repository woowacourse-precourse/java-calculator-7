package calculator.Model;

public class Input {
    String delimiter;
    String text;

    public boolean hasDelimiter() {
        return delimiter != null;
    }

    public boolean hasText() {
        return text != null;
    }
}
