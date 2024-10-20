package calculator.util;

public class Util {

    public static final int BEGIN_INDEX = 2;
    public static final int END_INDEX = 3;

    public static String getCustomDelimiter(String formula) {
        return formula.substring(BEGIN_INDEX, END_INDEX);
    }

    public static String newlineConverter(String string) {
        return string.replaceAll("\n", "\\\\n");
    }
}
