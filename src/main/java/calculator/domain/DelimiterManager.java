package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterManager {
    private List<Delimiter> delimiters;

    public DelimiterManager(List<Delimiter> delimiters) {
        this.delimiters = uniqueDelimiters(delimiters);
    }

    private List<Delimiter> uniqueDelimiters(List<Delimiter> delimiters) {
        return delimiters.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public void addDelimiter(String delimiter) {
        delimiters.add(new Delimiter(delimiter));
        delimiters = uniqueDelimiters(delimiters);
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }
}
