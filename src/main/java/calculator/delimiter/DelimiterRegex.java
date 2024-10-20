package calculator.delimiter;

import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;

import java.util.regex.Pattern;

public class DelimiterRegex {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final DelimiterRegex DEFAULT = new DelimiterRegex(DEFAULT_DELIMITER_REGEX);

    private final String regex;

    public static DelimiterRegex create(DelimiterLine delimiterLine) {
        if(delimiterLine == null || isNotSingleCharacter(delimiterLine))
            throw new IllegalArgumentException("잘못된 형식의 구분자");

        if(delimiterLine.isEmpty())
            return DEFAULT;
        return new DelimiterRegex(escape(delimiterLine.value()));
    }

    private static String escape(String value) {
        return Pattern.quote(value);
    }

    private static boolean isNotSingleCharacter(DelimiterLine delimiterLine) {
        return !delimiterLine.isEmpty() && delimiterLine.value().length() != 1;
    }

    private DelimiterRegex(String regex) {
        this.regex = regex;
    }

    public String[] split(String line) {
        return line.split(regex);
    }

    public String[] split(NumbersLine numbersLine) {
        return numbersLine.value().split(regex);
    }

    String getRegex() {
        return regex;
    }
}
