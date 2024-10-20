package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

    public static List<String> splitInput(String input) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        List<String> parts = new ArrayList<>();
        if (matcher.find()) {
            parts.add(matcher.group(1));
            parts.add(matcher.group(2));
        } else {
            parts.add(input);
        }
        return parts;
    }

    public static String createDelimiterPattern(Set<String> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[");
        for (String delimiter : delimiters) {
            regexBuilder.append(Pattern.quote(delimiter));
        }
        regexBuilder.append("]");
        return regexBuilder.toString();
    }
}
