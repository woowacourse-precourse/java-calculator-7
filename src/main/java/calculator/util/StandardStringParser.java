package calculator.util;

import java.util.Arrays;

public class StandardStringParser{

    public static final char[] STANDARD_SEPARATOR = {',', ':'};

    public static String[] split(String string) {
        return string.split(Arrays.toString(STANDARD_SEPARATOR));
    }
}
