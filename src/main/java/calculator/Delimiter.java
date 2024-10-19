package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private static final String BASE_DELIMITER = ",:";
    private List<String> delimiters = new ArrayList<>();

    public Delimiter() {
        for (int i = 0; i < BASE_DELIMITER.length(); i++) {
            delimiters.add(String.valueOf(BASE_DELIMITER.charAt(i)));
        }
    }

    public void add(String delimiter) {
        this.delimiters.add(delimiter);
    }

    public boolean isContain(String delimiter) {
        return delimiters.contains(delimiter);
    }
}
