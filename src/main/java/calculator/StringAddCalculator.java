package calculator;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndSum(final String str) {
        int result = 0;

        if (str == null || str.isEmpty()) {
            return 0;
        }

        final String[] split = splitIncludeCustomDelimiter(str);

        for (String s : split) {
            result += Integer.parseInt(s);
        }

        return result;
    }

    private static String[] splitIncludeCustomDelimiter(final String str) {
        return str.substring(str.indexOf("\n") + 1).split(DEFAULT_DELIMITERS + "|" + checkCustomDelimiter(str));
    }

    public static String checkCustomDelimiter(final String str) {
        if (str.startsWith("//")) {
            return str.substring(2, str.indexOf("\n"));
        }

        return "";
    }
}
