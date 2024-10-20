package calculator.util;

import java.util.stream.Stream;

public class Constants {
    public static final String NUMBER_INCLUDING_MINUS_AND_ZERO_REGEX = "[0-9-]";
    public static final String NUMBER_REGEX = ".*[0-9].*";

    public static final String ZERO = "0";
    public static final String MINUS = "-";
    public static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    public static final int DEFAULT_CUSTOM_DELI_END_IDX = -1;
    public static final String CUSTOM_DELI_START_SIGNAL = "//";
    public static final String CUSTOM_DELI_END_SIGNAL = "\\n";

    public static final String[] RESERVED_WORDS = Stream
            .of(DEFAULT_DELIMITERS,
                    new String[]{MINUS, CUSTOM_DELI_START_SIGNAL, CUSTOM_DELI_END_SIGNAL})
            .flatMap(Stream::of)
            .toArray(String[]::new);

    public static final int INTEGER_PARSE_MAX_LENGTH = 10;
}
