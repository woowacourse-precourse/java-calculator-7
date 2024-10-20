package calculator.service.strategy.customstrategy;

import static calculator.model.RegularExpression.CUSTOM_LINE;

import calculator.model.CustomDelimiter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterExtractor {
    public CustomDelimiter extractCustomDelimiter(String inputString) {
        String customDelimiterString = extractCustomDelimiterToString(inputString);
        return CustomDelimiter.createCustomDelimiter(customDelimiterStringToList(customDelimiterString));
    }

    private List<String> customDelimiterStringToList(String customDelimiterString) {
        return customDelimiterString.chars().mapToObj(delimiter -> Pattern.quote(String.valueOf((char) delimiter)))
                .collect(Collectors.toList());
    }

    private String extractCustomDelimiterToString(String inputString) {
        Pattern pattern = Pattern.compile(CUSTOM_LINE.getRegularExpression());
        Matcher matcher = pattern.matcher(inputString);
        CalculationCustomFormatValidator.validate(matcher);
        return matcher.group(1);
    }
}
