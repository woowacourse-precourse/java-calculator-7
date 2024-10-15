package calculator;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndSum(final String str) {
        int result = 0;

        if(str == null || str.isEmpty()) {
            return 0;
        }

        String[] split = str.split(DEFAULT_DELIMITERS);

        for (String s : split) {
            result += Integer.parseInt(s);
        }

        return result;
    }
}
