package calculator.delimiter;

public class Delimiter {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    static final Delimiter DEFAULT_DELIMITER = new Delimiter(DEFAULT_DELIMITER_REGEX);

    private final String customDelimiter;

    static Delimiter create(String delimiter) {
        if(delimiter == null || isNotSingleCharacter(delimiter))
            throw new IllegalArgumentException("잘못된 형식의 구분자");
        return new Delimiter(delimiter);
    }

    private static boolean isNotSingleCharacter(String delimiter) {
        return delimiter.length() != 1;
    }

    private Delimiter(String delimiter) {
        customDelimiter = delimiter;
    }

    public String[] split(String line) {
        if(hasCustomDelimiter())
            return line.split(customDelimiter);
        return line.split(DEFAULT_DELIMITER_REGEX);
    }

    private boolean hasCustomDelimiter() {
        return !customDelimiter.isEmpty();
    }
}
