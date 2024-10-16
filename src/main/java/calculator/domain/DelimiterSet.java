package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterSet {

    private final Set<String> delimiterSet;

    public DelimiterSet() {
        this.delimiterSet = new HashSet<>();
        init();
    }

    private void init() {
        delimiterSet.add(",");
        delimiterSet.add(":");
    }

    public void addAll(List<String> delimiters) {
        for (String delimiter : delimiters) {
            delimiterSet.add(delimiter);
        }
    }
}
