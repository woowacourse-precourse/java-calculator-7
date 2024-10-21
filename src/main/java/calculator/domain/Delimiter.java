package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {
    private String delimiterPattern;

    public Delimiter() {
        this.delimiterPattern = ",|:";
    }

    public void addCustomDelimiter(String customDelimiter) {
        this.delimiterPattern += "|" + Pattern.quote(customDelimiter);
    }

    public String[] split(String input) {
        return input.split(this.delimiterPattern);
    }
}
