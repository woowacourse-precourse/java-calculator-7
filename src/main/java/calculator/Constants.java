package calculator;

public class Constants {
    public static final int START_INDEX_AFTER_NEWLINE = 1;
    public static final char CUSTOM_DELIMITER_DEFINITION_END_CHAR = 'n';
    public static final String DEFAULT_DELIMITERS = ",:";
    public static final char REGEX_PREFIX = '[';
    public static final int BLANK_AS_ZERO = 0;
    public static final String NO_DIGITS = "^[^1-9]*$";
    public static final String CHECK_ONLY_NUMBERS = "^\\d+$";
    public static final String ALLOWED_CHARACTERS_REGEX = ".*[^1-9,:].*";
    public static final char REGEX_SUFFIX = ']';
    public static final String DELIMITER_PATTERN = "(?<=//)(.*?)(?=\\\\n)";
    public static final int START_INDEX = 0;
    public static final int SINGLE_ELEMENT = 1;


}
