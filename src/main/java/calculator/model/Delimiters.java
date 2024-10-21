package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private List<String> delimiterList;

    public Delimiters() {
        this.delimiterList = new ArrayList<>();
    }

    public List<String> getDelimiterList() {
        return delimiterList;
    }

    public void addDelimiter(String delimiter) {
        this.delimiterList.add(delimiter);
    }

    public void addAllDelimiter(List<String> delimiters) {
        this.delimiterList.addAll(delimiters);
    }
}