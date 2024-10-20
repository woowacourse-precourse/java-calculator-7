package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterManager {

    private final List<Delimiter> delimiters;

    public DelimiterManager(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public Pattern createDelimiterPattern() {
        String regex = delimiters.stream()
                .map(Delimiter::asPattern)
                .collect(Collectors.joining("|"));

        return Pattern.compile(regex);
    }
}