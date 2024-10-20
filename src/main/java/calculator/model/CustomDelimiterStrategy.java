package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private static final String CUSTOM_DELIMITERS = "//(.+)\\Q\\n\\E(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITERS);

    @Override
    public String[] getStringNumbersArray(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbers = matcher.group(2);
            String[] numberArray = numbers.split(customDelimiter, -1);
            return checkDuplicatedDelimiters(numberArray);
        }
        throw new IllegalArgumentException(
                "커스텀 구분자 형식이 아닙니다.");
    }
}