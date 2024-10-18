package calculator.extractor;

import calculator.constant.CustomDelimiter;
import calculator.extractor.result.StringDelimiterResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.CustomDelimiter.getCustomDelimiterPattern;

public class StringDelimiterExtractor {

    public StringDelimiterResult extract(String input) {
        if (!hasCustomDelimiter(input)) {
            return StringDelimiterResult.of(input);
        }

        Pattern pattern = getCustomDelimiterPattern();
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group(1);
        String text = matcher.group(2);

        return StringDelimiterResult.of(text, customDelimiter);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CustomDelimiter.START_PREFIX);
    }
}
