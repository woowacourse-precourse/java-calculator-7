package calculator.model.separate;

import calculator.model.exception.MultiCustomDelimiterException;
import calculator.model.exception.NotAllowedPositionException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.common.SystemConstant.emptyString;
import static calculator.common.SystemConstant.maxCustomDelimiterCount;
import static calculator.model.separate.BusinessRegex.*;
import static org.junit.platform.commons.util.StringUtils.isNotBlank;

public class SeparateManager {

    private final List<String> basicDelimiters;
    private final List<String> customCheckers;
    private final String orDelimiter;
    private String customDelimiter;


    // Constructor
    private SeparateManager() {
        basicDelimiters = Delimiter.basic();
        customCheckers = Delimiter.customChecker();
        orDelimiter = Delimiter.or();
    }

    public static SeparateManager initiate() {
        return new SeparateManager();
    }

    // Validation
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

    // Domain Logic - public
    private Matcher createMatcher(String source, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(source);
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

    public void extractCustomDelimiter(String source) {
        String customDelimiter = parseCustomDelimiter(source);
        if (isNotBlank(customDelimiter)) {
            this.customDelimiter = customDelimiter;
        }
    }
}
