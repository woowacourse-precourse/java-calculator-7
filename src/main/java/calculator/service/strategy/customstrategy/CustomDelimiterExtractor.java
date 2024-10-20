package calculator.service.strategy.customstrategy;

import static calculator.model.RegularExpression.CUSTOM_LINE;

import calculator.model.delimiter.Delimiter;
import calculator.service.strategy.PatternMatcher;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterExtractor {
    private final PatternMatcher patternMatcher;

    public CustomDelimiterExtractor(PatternMatcher patternMatcher) {
        this.patternMatcher = patternMatcher;
    }

    public Delimiter extractCustomDelimiter(String inputString) {
        String customDelimiterString = extractCustomDelimiterToString(inputString);
        return Delimiter.createDelimiter(customDelimiterStringToList(customDelimiterString));
    }

    private List<String> customDelimiterStringToList(String customDelimiterString) {
        return customDelimiterString.chars().mapToObj(delimiter -> Pattern.quote(String.valueOf((char) delimiter)))
                .collect(Collectors.toList());
    }

    private String extractCustomDelimiterToString(String inputString) {
        return patternMatcher.findFirstGroup(CUSTOM_LINE.getRegularExpression(), inputString);
    }
}
