package calculator.split;

public class StringSplit {
    public static String getFrontString(String string) {
        String[] split = string.split("\n");
        return split[0];
    }

    public static String getBackString(String string) {
        String[] split = string.split("\n", 2);
        return split[1];
    }
}
