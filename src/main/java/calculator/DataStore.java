package calculator;

import java.util.List;

public class DataStore {

    private String target;
    private List<Character> delimiter;

    public DataStore(String target) {
        this.target = target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setDelimiter(List<Character> delimiter) {
        this.delimiter = delimiter;
    }
}
