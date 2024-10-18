package calculator.delimiter.domain;

import calculator.util.pattern.PatternUtils;

import java.util.List;
import java.util.regex.Pattern;

import static calculator.util.pattern.PatternUtils.SPLIT_DELIMITER;


public class Delimiters {

    private final List<Delimiter> values;

    public Delimiters(List<Delimiter> delimiters) {
        this.values = delimiters;
    }

    public String splitRegex() {
        return join(SPLIT_DELIMITER);
    }

    public Pattern pattern() {
        return Pattern.compile(splitRegex());
    }

    private String join(String delimiterString) {
        return PatternUtils.join(delimiterString, values.stream().map(Delimiter::value).toList());
    }
}
