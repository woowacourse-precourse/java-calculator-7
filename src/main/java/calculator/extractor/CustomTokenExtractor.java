package calculator.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomTokenExtractor implements TokenExtractor {
    private static final String CUSTOM_TOKEN_PREFIX = "//";
    private static final String CUSTOM_TOKEN_SUFFIX = "\\n";

    @Override
    public List<String> extract(String input) {
        if (!isCustomTokenFormat(input)) {
            return null;  // 커스텀 토큰 형식이 아니면 null 반환
        }
        String customToken = extractCustomToken(input);
        String numberString = extractNumberString(input);
        return splitNumbers(numberString, customToken);
    }

    public boolean isCustomTokenFormat(String input) {
        return input.startsWith(CUSTOM_TOKEN_PREFIX) && input.contains(CUSTOM_TOKEN_SUFFIX);
    }

    public String extractCustomToken(String input) {
        int tokenEndIndex = input.indexOf(CUSTOM_TOKEN_SUFFIX);
        return Pattern.quote(input.substring(CUSTOM_TOKEN_PREFIX.length(), tokenEndIndex));
    }

    public String extractNumberString(String input) {
        int numberStartIndex = input.indexOf(CUSTOM_TOKEN_SUFFIX) + CUSTOM_TOKEN_SUFFIX.length();
        return input.substring(numberStartIndex);
    }

    public List<String> splitNumbers(String numberString, String token) {
        if (numberString.isEmpty()) {
            return Arrays.asList("0");
        }
        return Arrays.stream(numberString.split(token))
                .filter(this::isNumber)
                .collect(Collectors.toList());
    }

    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}