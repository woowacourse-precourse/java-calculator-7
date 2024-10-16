package calculator.model.separate;

import calculator.model.exception.MultiCustomDelimiterException;
import calculator.model.exception.NotAllowedPositionException;
import calculator.model.exception.ParseToIntegerFailedException;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.common.SystemConstant.emptyString;
import static calculator.common.SystemConstant.maxCustomDelimiterCount;
import static calculator.model.separate.BusinessRegex.*;
import static org.junit.platform.commons.util.StringUtils.isBlank;
import static org.junit.platform.commons.util.StringUtils.isNotBlank;

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
    private Matcher createMatcher(String source, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(source);
    }

    public boolean canParseCustomDelimiter(String source) {
        Matcher matcher = createMatcher(source, customDelimiterStartCondition());
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
        Matcher matcher = createMatcher(source, customDelimiterParseRegex());
        if (matcher.find()) {
            return matcher.group(1);
        }
        return emptyString();
    }

    public void validateCustomDelimiterCount(String source) {
        Matcher matcher = createMatcher(source, customDelimiterCountRegex());

        int delimiterCount = 0;
        while (matcher.find()) {
            delimiterCount++;
        }
        if (delimiterCount > maxCustomDelimiterCount()) {
            throw new MultiCustomDelimiterException();
        }
    }

    public void validateCustomDelimiterPosition(String source) {
        Matcher matcher = createMatcher(source, customDelimiterPositionRegex());
        if (!matcher.find()) {
            throw new NotAllowedPositionException();
        }
    }

    public List<Integer> separate(String source) {
        String sourceReplacedByRegexes = processReplacing(source);
        String[] tokens = sourceReplacedByRegexes.split(getAllDelimiters());
        return Arrays.stream(tokens)
                .filter(StringUtils::isNotBlank)
                .map(this::tryParseToInt)
                .toList();
    }

    private String processReplacing(String source) {
        return source.replaceAll(whiteSpaceRegex(), emptyString())
                .replaceAll(customDelimiterParseRegex(), emptyString());
    }

    public Integer tryParseToInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new ParseToIntegerFailedException();
        }
    }

    public String getAllDelimiters() {
        return mergeDelimiters().toString();
    }

    public List<String> mergeDelimiters() {
        List<String> mergedDelimiters = new ArrayList<>(basicDelimiters);
        if (isAddable(customDelimiter)) {
            mergedDelimiters.add(customDelimiter);
        }
        return mergedDelimiters;
    }

    private boolean isAddable(String customDelimiter) {
        if (isBlank(customDelimiter)) {
            return false;
        }
        if (basicDelimiters.contains(customDelimiter)) {
            return false;
        }
        return true;
    }
}
