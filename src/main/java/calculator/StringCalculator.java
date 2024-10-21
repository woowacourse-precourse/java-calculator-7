package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    public static int calculate(String input) {
        Pattern numPattern = Pattern.compile("^\\d+([,:]\\d+)*$");
        Pattern delimPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

        Matcher numMatcher = numPattern.matcher(input);
        Matcher delimMatcher = delimPattern.matcher(input);
        int total = 0;

        if (numMatcher.matches()) {
            String[] nums = input.split("[,:]");
            for (String n : nums) {
                total += Integer.parseInt(n);
            }
        }
    }
}