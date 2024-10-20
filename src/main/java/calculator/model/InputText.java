package calculator.model;

public class InputText {
    private final Delimiter delimiter;
    private final PlainText plainText;

    public InputText(String delimiter, String text) {
        this.delimiter = new Delimiter(delimiter);
        this.plainText = new PlainText(text);
    }
}