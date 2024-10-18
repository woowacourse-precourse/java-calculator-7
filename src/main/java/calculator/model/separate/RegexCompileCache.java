package calculator.model.separate;

import static calculator.model.separate.RegexPattern.customDelimiterCountRegex;
import static calculator.model.separate.RegexPattern.customDelimiterParseRegex;
import static calculator.model.separate.RegexPattern.customDelimiterPositionRegex;
import static calculator.model.separate.RegexPattern.customDelimiterStartConditionRegex;
import static calculator.model.separate.RegexPattern.replaceConditionRegex;
import static java.util.regex.Pattern.compile;

import java.util.regex.Pattern;

public enum RegexCompileCache {
    CUSTOM_DELIMITER_COUNT(compile(customDelimiterCountRegex())),
    CUSTOM_DELIMITER_POSITION(compile(customDelimiterPositionRegex())),
    CUSTOM_DELIMITER_PARSE(compile(customDelimiterParseRegex())),
    CUSTOM_DELIMITER_PARSE_CONDITION(compile(customDelimiterStartConditionRegex())),
    REPLACE_CONDITION(compile(replaceConditionRegex()));

    private final Pattern pattern;

    RegexCompileCache(Pattern pattern) {
        this.pattern = pattern;
    }

    public static Pattern findBy(RegexCompileCache patterType) {
        return patterType.pattern;
    }
}
