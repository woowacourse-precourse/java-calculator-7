package calculator.delimiter.custom.pattern_matcher;

import java.util.Optional;
import java.util.regex.Matcher;

public interface CustomDelimiterPatternMatcher {

    Matcher match(String value);

    Optional<String> extractDelimiterGroup(String value);

    Optional<String> extractTrimmedGroup(String value);
}
