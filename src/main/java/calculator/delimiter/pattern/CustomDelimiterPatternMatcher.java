package calculator.delimiter.pattern;

import java.util.Optional;
import java.util.regex.Matcher;

public interface CustomDelimiterPatternMatcher {

    Matcher match(String value);

    default Optional<Matcher> matchAndFind(String value) {
        Matcher matcher = match(value);
        return matcher.find() ? Optional.of(matcher) : Optional.empty();
    }

    Optional<String> extractDelimiterGroup(String value);

    Optional<String> extractTrimmedGroup(String value);
}
