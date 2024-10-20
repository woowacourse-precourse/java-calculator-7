package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private String SEPARATOR = ",|:";

    public String[] separate(String input) {
        return separate(input, SEPARATOR);
    }

    public String[] separate(String input, String separator) {
        String regex = separator;
        return input.split(regex);
    }

    public String addCustomSeparator(String regex, String customSeparator) {
        return regex.concat("|" + customSeparator);
    }

    public String getSeparator(String input) {
        String regex = SEPARATOR;
        Matcher match = Pattern.compile(Constants.REGEX_CUSTOM_SEPARATOR_PATTERN).matcher(input);

        while (match.find()) {
            String customSeparator = match.group(1);
            regex = addCustomSeparator(regex, customSeparator);
        }

        return regex;
    }
}
