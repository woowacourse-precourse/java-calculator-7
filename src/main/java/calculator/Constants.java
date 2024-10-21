package calculator;

import java.util.*;

public final class Constants {
    private Constants() {}
    public static final String CUSTOM_START = "//";
    public static final Set<Character> DELIMITERS = new HashSet<>(){
        {
            add(':');
            add(',');
        }
    };
}
