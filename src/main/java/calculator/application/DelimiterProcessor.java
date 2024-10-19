package calculator.application;

import calculator.common.ErrorMessage;
import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import calculator.domain.Delimiter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterProcessor {

    private final List<Delimiter> delimiters;

    public DelimiterProcessor(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public String[] extractNumberStrings(String input) {
        return delimiters.stream()
                .filter(d -> d.supports(input))
                .findFirst()
                .map(d -> d.split(input))
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR));
    }
}
