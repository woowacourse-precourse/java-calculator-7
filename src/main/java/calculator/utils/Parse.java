package calculator.utils;

import java.util.*;
import java.util.regex.*;

public class Parse {

    public static List<String> splitUserInputTowPart(String userInput) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(userInput);

        List<String> twoPartUserInput = new ArrayList<>();
        if (matcher.find()) {
            twoPartUserInput.add(matcher.group(1));
            twoPartUserInput.add(matcher.group(2));
        } else {
            twoPartUserInput.add(userInput);
        }
        return twoPartUserInput;
    }

    public static String buildMultiDelimiterFromSet(Set<String> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[");
        for (String delimiter : delimiters) {
            regexBuilder.append(Pattern.quote(delimiter));
        }
        regexBuilder.append("]");
        return regexBuilder.toString();
    }
}
