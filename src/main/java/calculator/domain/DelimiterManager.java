package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterManager {
    private final List<Delimiter> delimiters;

    public DelimiterManager(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }
}
