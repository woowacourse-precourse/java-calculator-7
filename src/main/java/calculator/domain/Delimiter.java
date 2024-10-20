package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiter {

    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private final Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITER);

    public void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public List<String> getDelimiters() {
        return delimiters.stream().toList();
    }
}
