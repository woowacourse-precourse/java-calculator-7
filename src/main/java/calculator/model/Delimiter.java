package calculator.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static Set<String> delimiter;

    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|:");
    }

    public Delimiter() {
        delimiter = new HashSet<>();
        delimiter.add(",");
        delimiter.add(":");
    }

    public static String[] splitWithCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression.replace("\\n", "\n"));
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter.add(customDelimiter);
            String delimiterToUse = customAndBasicDelimiter();
            String[] tokens = m.group(2).split(delimiterToUse);
            return tokens;
        }
        return splitWithDelimiter(expression);
    }

    private static String customAndBasicDelimiter() {
        return delimiter.stream()
                .collect(Collectors.joining("|"));
    }


}
