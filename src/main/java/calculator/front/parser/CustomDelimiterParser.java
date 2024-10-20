package calculator.front.parser;

import calculator.front.exception.FrontExceptionMessage;
import calculator.front.exception.message.NumberAsDelimiterException;
import calculator.front.input.CustomDelimiterParsedInput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private static final Pattern patternWithDelimiter = Pattern.compile("^//(.)\\\\n(.*)$");

    public static CustomDelimiterParsedInput parse(String rawInput) {

        Matcher matcher = patternWithDelimiter.matcher(rawInput);
        // 커스텀 구분자가 존재할 때
        if (matcher.matches()) {
            char customDelimiter = matcher.group(1).charAt(0);
            if (customDelimiter >= '0' && customDelimiter <= '9') {
                throw new NumberAsDelimiterException(FrontExceptionMessage.NUMBER_AS_DELIMITER_EXCEPTION.getMessage());
            }
            return new CustomDelimiterParsedInput(customDelimiter, matcher.group(2));
        }
        // 존재하지 않을 때
        return new CustomDelimiterParsedInput(rawInput);
    }
}