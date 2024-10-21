package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class DelimiterRepository {
    private final List<String> delimiters;

    public DelimiterRepository() {
        delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public void addDelimiter(String delim) {
        delimiters.add(delim);
    }
}
