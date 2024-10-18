package calculator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String EXTRACTOR_REGEX = "//(.*?)\\n";
    private static final Pattern EXTRACT_PATTERN = Pattern.compile(EXTRACTOR_REGEX);
    private static final int REQUIRED_GROUP_NUMBER = 1;

    public List<String> extractCustom(String value) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = EXTRACT_PATTERN.matcher(value);

        while (matcher.find()) {
            delimiters.add(matcher.group(REQUIRED_GROUP_NUMBER));
        }

        return delimiters;
    }
}
