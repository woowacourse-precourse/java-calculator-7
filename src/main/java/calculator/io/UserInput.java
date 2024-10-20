package calculator.io;

public class UserInput {

    private final String delimiter;
    private final String plainText;

    public UserInput(String delimiter, String plainText) {
        this.delimiter = delimiter;
        this.plainText = plainText;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getPlainText() {
        return plainText;
    }
}