package calculator.model;

public class InputText {
    private final Delimiter delimiter;
    private final PlainText plainText;

    public InputText(String delimiter, String text) {
        this.delimiter = new Delimiter(delimiter);
        this.plainText = new PlainText(text);
        validateAfterInitialize(this.delimiter, this.plainText);
    }

    public Tokens tokenize() {
        return plainText.tokenizedBy(delimiter);
    }

    private void validateAfterInitialize(Delimiter delimiter, PlainText plainText) {
        if (plainText.hasCharExcluding(delimiter)) {
            throw new IllegalArgumentException("구분자와 동일하지 않은 문자는 지원하지 않습니다.");
        }
    }
}