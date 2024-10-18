package calculator.model.separate;

import static calculator.common.SystemConstant.emptyString;
import static calculator.common.SystemConstant.maxCustomDelimiterCount;
import static calculator.model.separate.RegexCompileCache.CUSTOM_DELIMITER_COUNT;
import static calculator.model.separate.RegexCompileCache.CUSTOM_DELIMITER_PARSE;
import static calculator.model.separate.RegexCompileCache.CUSTOM_DELIMITER_PARSE_CONDITION;
import static calculator.model.separate.RegexCompileCache.CUSTOM_DELIMITER_POSITION;
import static calculator.model.separate.RegexCompileCache.REPLACE_CONDITION;
import static calculator.model.separate.RegexCompileCache.findBy;
import static org.junit.platform.commons.util.StringUtils.isNotBlank;

import calculator.model.exception.MultiCustomDelimiterException;
import calculator.model.exception.NotAllowedPositionException;
import calculator.model.exception.ParseToIntegerFailedException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

public class SeparateManager {

    private final List<String> basicDelimiters;
    private String customDelimiter;

    // Constructor
    private SeparateManager() {
        basicDelimiters = Delimiter.basic();
    }

    public static SeparateManager initiate() {
        return new SeparateManager();
    }

    // Method
    private Matcher createMatcher(String source, RegexCompileCache patternType) {
        Pattern pattern = findBy(patternType);
        return pattern.matcher(source);
    }

    public boolean canParseCustomDelimiter(String source) {
        Matcher matcher = createMatcher(source, CUSTOM_DELIMITER_PARSE_CONDITION);
        return matcher.find();
    }

    public void extractCustomDelimiter(String source) {
        String delimiter = parseCustomDelimiter(source);
        if (isNotBlank(delimiter)) {
            this.customDelimiter = delimiter;
        }
    }

    public String parseCustomDelimiter(String source) {
        validateCustomDelimiterPosition(source);
        validateCustomDelimiterCount(source);
        Matcher matcher = createMatcher(source, CUSTOM_DELIMITER_PARSE);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return emptyString();
    }

    public void validateCustomDelimiterCount(String source) {
        Matcher matcher = createMatcher(source, CUSTOM_DELIMITER_COUNT);

        int delimiterCount = 0;
        while (matcher.find()) {
            delimiterCount++;
        }
        if (delimiterCount > maxCustomDelimiterCount()) {
            throw new MultiCustomDelimiterException();
        }
    }

    public void validateCustomDelimiterPosition(String source) {
        Matcher matcher = createMatcher(source, CUSTOM_DELIMITER_POSITION);
        if (!matcher.find()) {
            throw new NotAllowedPositionException();
        }
    }

    public List<Integer> separate(String source) {
        String sourceReplacedByRegexes = processReplacing(source);
        String finalDelimiters = this.toString();
        String[] tokens = sourceReplacedByRegexes.split(finalDelimiters);
        return Arrays.stream(tokens)
                .filter(StringUtils::isNotBlank)
                .map(this::tryParseToInt)
                .toList();
    }

    private String processReplacing(String source) {
        Matcher matcher = createMatcher(source, REPLACE_CONDITION);
        return matcher.replaceAll(emptyString());
    }

    public Integer tryParseToInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new ParseToIntegerFailedException();
        }
    }

    @Override
    public String toString() {
        StringBuilder regexBuilder = new StringBuilder();
        allDelimiters().forEach(regexBuilder::append);
        return String.format("[%s]", regexBuilder);
    }

    public Set<String> allDelimiters() {
        Set<String> mergedDelimiters = new HashSet<>(basicDelimiters);
        if (isAddable(customDelimiter)) {
            mergedDelimiters.add(customDelimiter);
        }
        return mergedDelimiters;
    }

    private boolean isAddable(String customDelimiter) {
        return isNotBlank(customDelimiter) && !basicDelimiters.contains(customDelimiter);
    }
}
