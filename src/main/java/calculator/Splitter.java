package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String PATTERN = "^//(.*?)\\n";

    private List<String> extractDelimiters(String text) {
        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        addCustomDelimiter(text, delimiters);

        return delimiters;
    }

    private void addCustomDelimiter(String text, List<String> delimiters) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            delimiters.add(matcher.group(1));
        }
    }
}
