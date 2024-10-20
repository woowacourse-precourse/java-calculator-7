package calculator.service.strategy.customstrategy;

import static calculator.model.RegularExpression.CUSTOM_LINE;

import calculator.model.CustomDelimiter;
import calculator.service.strategy.PatternMatcherUtil;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterExtractor {
    private final PatternMatcherUtil patternMatcherUtil;

    public CustomDelimiterExtractor(PatternMatcherUtil patternMatcherUtil) {
        this.patternMatcherUtil = patternMatcherUtil;
    }

    public CustomDelimiter extractCustomDelimiter(String inputString) {
        String customDelimiterString = extractCustomDelimiterToString(inputString);
        return CustomDelimiter.createCustomDelimiter(customDelimiterStringToList(customDelimiterString));
    }

    private List<String> customDelimiterStringToList(String customDelimiterString) {
        return customDelimiterString.chars().mapToObj(delimiter -> Pattern.quote(String.valueOf((char) delimiter)))
                .collect(Collectors.toList());
    }

    private String extractCustomDelimiterToString(String inputString) {
        return patternMatcherUtil.match(CUSTOM_LINE.getRegularExpression(), inputString);
    }
}
