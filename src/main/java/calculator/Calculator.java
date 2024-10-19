package calculator;

public class Calculator {
    private static boolean isCustomDelimiter;
    private static char customDelimiter;

    public static int calculate(String input) {
        Parser.checkDelimiter(input);

        int res = 0;
        return res;
    }

    public static void setIsCustomDelimiter(boolean value) {
        isCustomDelimiter = value;
    }

    public static boolean getIsCustomDelimiter() {
        return isCustomDelimiter;
    }
}
