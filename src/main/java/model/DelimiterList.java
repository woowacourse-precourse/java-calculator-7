package model;

import java.util.ArrayList;
import java.util.List;

public class DelimiterList {
    private final List<Character> delimiters = new ArrayList<Character>();

    public DelimiterList() {
    }

    public void add(char newDelimiter) {
        delimiters.add(newDelimiter);
    }

    public boolean contains(char delimiter) {
        return delimiters.contains(delimiter);
    }
}
