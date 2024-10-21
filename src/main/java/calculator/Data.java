package calculator;

public class Data {

    private final String separators;
    private final String str;

    public Data(String separators, String str) {
        this.separators = separators;
        this.str = str;
    }

    public String getSeparators() {
        return separators;
    }

    public String getStr() {
        return str;
    }
}
