package calculator.delimiter.pattern;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultCustomDelimiterPatternMatcher implements CustomDelimiterPatternMatcher {

    private final String DELIMITER_PREFIX = "//";
    private final String DELIMITER_SUFFIX = "\\\\n";
    private final Pattern DELIMITER_PATTERN = Pattern.compile(
            "^" + DELIMITER_PREFIX + "(.*)" + DELIMITER_SUFFIX + "(.*)"
    );

    @Override
    public Matcher match(String value) {
        return DELIMITER_PATTERN.matcher(value);
    }

    @Override
    public Optional<String> extractDelimiterGroup(String value) {
        return matchAndFind(value).map(matcher -> matcher.group(1));
    }

    @Override
    public Optional<String> extractTrimmedGroup(String value) {
        return matchAndFind(value).map(matcher -> matcher.group(2));
    }

    private Optional<Matcher> matchAndFind(String value) {
        Matcher matcher = match(value);
        return matcher.find() ? Optional.of(matcher) : Optional.empty();
    }
}
