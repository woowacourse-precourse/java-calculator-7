package calculator.dto;

public class Data {

    private final char[] separators;
    private final char[] contents;

    public Data(char[] separators, char[] contents) {
        this.separators = separators;
        this.contents = contents;
    }

    public char[] getSeparators() {
        return separators;
    }

    public char[] getContents() {
        return contents;
    }
}
