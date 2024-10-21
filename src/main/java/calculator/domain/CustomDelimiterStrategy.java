package calculator.domain;

import calculator.global.DelimiterUtils;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CustomDelimiterStrategy implements DelimiterStrategy{
    private final String customDelimiter;

    public CustomDelimiterStrategy(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    @Override
    public List<String> split(String input) {
        int newLineIndex = DelimiterUtils.findNewlineIndex(input);
        String numberParts = input.substring(newLineIndex + 2);
        return Arrays.asList(numberParts.split(Pattern.quote(customDelimiter)));
    }
}
