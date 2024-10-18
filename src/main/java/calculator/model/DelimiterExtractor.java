package calculator.model;

import static calculator.common.DelimiterConstant.CUSTOM_EXTRACTOR_REGEX;
import static calculator.common.DelimiterConstant.REQUIRED_MATCHER_GROUP_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final Pattern EXTRACT_PATTERN = Pattern.compile(CUSTOM_EXTRACTOR_REGEX);

    public List<String> extractCustom(String value) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = EXTRACT_PATTERN.matcher(value);

        while (matcher.find()) {
            delimiters.add(matcher.group(REQUIRED_MATCHER_GROUP_NUMBER));
        }

        return delimiters;
    }
}
