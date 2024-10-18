package calculator.extractor;


import static calculator.util.Message.커스텀_토큰_prefix_예외_발생;
import static calculator.util.Message.커스텀_토큰_예외_발생;
import static calculator.util.Token.CUSTOM_TOKEN_PREFIX;
import static calculator.util.Token.NEW_LINE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CustomTokenExtractor implements TokenExtractor {
    @Override
    public List<String> extract(String input) {
        validateCustomTokenFormat(input);
        String tokenIndex = extractToken(input);
        String numberString = extractNumberString(input);
        return splitNumbers(numberString, tokenIndex);
    }

    public void validateCustomTokenFormat(String input) {
        if (!input.startsWith(CUSTOM_TOKEN_PREFIX)) {
            throw new IllegalArgumentException(커스텀_토큰_prefix_예외_발생);
        }
        if (!input.contains(NEW_LINE)) {
            throw new IllegalArgumentException(커스텀_토큰_예외_발생);
        }
    }

    public String extractToken(String input) {
        int tokenIndex = input.indexOf(NEW_LINE);
        return Pattern.quote(input.substring(CUSTOM_TOKEN_PREFIX.length(), tokenIndex));
    }

    public String extractNumberString(String input) {
        int tokenIndex = input.indexOf(NEW_LINE);
        return input.substring(tokenIndex + NEW_LINE.length());
    }

    public List<String> splitNumbers(String numberString, String tokenIndex) {
        return Arrays.asList(numberString.split(tokenIndex));
    }
}
