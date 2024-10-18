package calculator.delimiter.domain;

import calculator.util.pattern.PatternUtils;

import java.util.List;

import static calculator.util.pattern.PatternUtils.SPLIT_DELIMITER;


public class Delimiters {

    private final List<Delimiter> values;

    public Delimiters(List<Delimiter> delimiters) {
        this.values = delimiters;
    }

    public String splitRegex() {
        return join(SPLIT_DELIMITER);
    }

    private String join(String delimiterString) {
        return PatternUtils.join(delimiterString, values.stream().map(Delimiter::value).toList());
    }
}
