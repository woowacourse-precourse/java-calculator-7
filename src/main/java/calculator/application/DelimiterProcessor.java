package calculator.application;

import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import calculator.domain.Delimiter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterProcessor {

    private final List<Delimiter> delimiters;

    public DelimiterProcessor() {
        delimiters = List.of(
                new DefaultDelimiter(),
                new CustomDelimiter()
        );
    }

    public String[] extractNumberStrings(String input) {
        return delimiters.stream()
                .filter(d -> d.supports(input))
                .findFirst()
                .map(d -> d.split(input))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 숫자 형식입니다."));
    }
}
