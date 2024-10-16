package calculator.dto;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Data{" +
                "separators=" + Arrays.toString(separators) +
                ", contents=" + Arrays.toString(contents) +
                '}';
    }
}
