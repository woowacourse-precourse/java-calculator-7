package calculator.utils;


import calculator.entity.Index;

public final class Constants {

    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String CUSTOM_SEP_START_STRING = "//";
    public static final String CUSTOM_SEP_END_STRING = "\\n";

    public static final Index CUSTOM_SEPARATOR_LENGTH = new Index(5);
    public static final Index CUSTOM_SEPARATOR_IDX = new Index(2);
    public static final Index CUSTOM_SEPARATOR_END_IDX = new Index(3);

    private Constants() {
    }
}
