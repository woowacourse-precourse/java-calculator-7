package calculator.delimiter;

import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;

public class Delimiter {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Delimiter DEFAULT_DELIMITER = new Delimiter(DEFAULT_DELIMITER_REGEX);

    private final String customDelimiter;

    public static Delimiter create(DelimiterLine delimiterLine) {
        if(delimiterLine == null || isNotSingleCharacter(delimiterLine))
            throw new IllegalArgumentException("잘못된 형식의 구분자");

        if(delimiterLine.isEmpty())
            return DEFAULT_DELIMITER;
        return new Delimiter(delimiterLine.value());
    }

    private static boolean isNotSingleCharacter(DelimiterLine delimiterLine) {
        return !delimiterLine.isEmpty() && delimiterLine.value().length() != 1;
    }

    private Delimiter(String delimiter) {
        customDelimiter = delimiter;
    }

    public String[] split(String line) {
        return line.split(customDelimiter);
    }

    public String[] split(NumbersLine numbersLine) {
        return numbersLine.value().split(customDelimiter);
    }

    String getCustomDelimiter() {
        return customDelimiter;
    }
}
