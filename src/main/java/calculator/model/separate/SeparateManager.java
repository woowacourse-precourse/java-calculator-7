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

    public Integer tryParseToInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new ParseToIntegerFailedException();
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
        String delimiter = parseCustomDelimiter(source);
        if (isNotBlank(delimiter)) {
            this.customDelimiter = delimiter;
        }
    }

    //FIXME : 네이밍 개선 필요 (mainSource, splitted)
    public List<Integer> split(String source) {
        String mainSource = source.replaceAll(customDelimiterParseRegex(), emptyString());
        String[] splitted = mainSource.split(getAllDelimiters());
        return Arrays.stream(splitted)
                .filter(StringUtils::isNotBlank)
                .map(this::tryParseToInt)
                .toList();
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
