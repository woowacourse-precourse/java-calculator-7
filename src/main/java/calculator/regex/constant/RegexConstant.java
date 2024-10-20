package calculator.regex.constant;

import java.util.regex.Pattern;

public class RegexConstant {
    private static final String PREFIX_CUSTOM_SEPARATOR = "^//";
    private static final String SUFFIX_CUSTOM_SEPARATOR = "\\\\n";

    private static final String DEFAULT_SEPARATOR = "[,:]";

    private static final String OR = "|";
    private static final String REPEAT = "*";

    private static final String ALPHANUMERIC_EXCLUDING_DIGITS = "\\D";
    private static final String ONE_OR_MORE_DIGITS = "\\d+";
    private static final String POSITIVE_INT = "[1-9]\\d";

    private static final String START_OF_STRING = "^";
    private static final String END_OF_STRING = "$";

    private static final String NON_DIGIT_NON_WHITESPACE_GROUP = "([^\\d\\s])";
    private static final String NON_DIGIT_NON_WHITESPACE_NON_DOT_GROUP = "([^\\d\\s.])";

    private static final String ZERO_WITH_DECIMAL = "0\\.";
    private static final String VALID_DECIMAL_PATTERN = ZERO_WITH_DECIMAL + "(?!0+([,:]|$))" + ONE_OR_MORE_DIGITS;
    private static final String OPTIONAL_DECIMAL_PATTERN = "\\." + ONE_OR_MORE_DIGITS;
    private static final String OPTIONAL = "?";

    private static final String NON_CAPTURING_GROUP = "?:";
    private static final String NON_ZERO_REPEAT = "?!0+";


    public static final Pattern DEFAULT_SEPARATOR_REGEX = Pattern.compile(
            POSITIVE_INT + REPEAT +
                    "(" + DEFAULT_SEPARATOR + POSITIVE_INT + REPEAT + ")"
                    + REPEAT);


    public static final Pattern DEFAULT_SEPARATOR_DOUBLE_REGEX = Pattern.compile(
            START_OF_STRING +
                    "(" + NON_CAPTURING_GROUP + VALID_DECIMAL_PATTERN + OR + POSITIVE_INT + REPEAT + "(" + NON_CAPTURING_GROUP + OPTIONAL_DECIMAL_PATTERN + ")" + OPTIONAL + ")" +
                    "(" + NON_CAPTURING_GROUP + DEFAULT_SEPARATOR + "(" + NON_CAPTURING_GROUP + VALID_DECIMAL_PATTERN + OR + POSITIVE_INT + REPEAT + "(" + NON_CAPTURING_GROUP + OPTIONAL_DECIMAL_PATTERN + ")" + OPTIONAL + "))" +
                    REPEAT + END_OF_STRING);


    public static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile(
            PREFIX_CUSTOM_SEPARATOR + NON_DIGIT_NON_WHITESPACE_GROUP + SUFFIX_CUSTOM_SEPARATOR + POSITIVE_INT + REPEAT +
                    "(" + "\\1" + POSITIVE_INT + REPEAT + ")" +
                    REPEAT + END_OF_STRING);


    public static final Pattern CUSTOM_SEPARATOR_DOUBLE_REGEX = Pattern.compile(
            PREFIX_CUSTOM_SEPARATOR + NON_DIGIT_NON_WHITESPACE_NON_DOT_GROUP + SUFFIX_CUSTOM_SEPARATOR +
                    "(" + ZERO_WITH_DECIMAL + "(" + NON_ZERO_REPEAT + "(" + END_OF_STRING + OR + ALPHANUMERIC_EXCLUDING_DIGITS + ")" + ")" + ONE_OR_MORE_DIGITS + OR + POSITIVE_INT + REPEAT + "(" + OPTIONAL_DECIMAL_PATTERN + ")" + OPTIONAL + ")" +
                    "(" + "\\1" + "(" + ZERO_WITH_DECIMAL + "(" + NON_ZERO_REPEAT + "(" + END_OF_STRING + OR + ALPHANUMERIC_EXCLUDING_DIGITS + ")" + ")" + ONE_OR_MORE_DIGITS + OR + POSITIVE_INT + REPEAT + "(" + OPTIONAL_DECIMAL_PATTERN + ")" + OPTIONAL + ")" + ")" + REPEAT + END_OF_STRING);


    public static final Pattern BLANK_REGEX = Pattern.compile(START_OF_STRING + END_OF_STRING);
}
