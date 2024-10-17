package calculator.dto;

public class Data {

    private final String separators;
    private final String contents;

    public Data(String separators, String contents) {
        this.separators = separators;
        this.contents = contents;
    }

    public String getSeparators() {
        return separators;
    }

    public String getContents() {
        return contents;
    }
}
