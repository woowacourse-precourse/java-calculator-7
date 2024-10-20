package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+)\n";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public List<String> extract(String input) {
        List<String> customDelimiters = new ArrayList<>();

        if (!input.startsWith("//")) {
            if (PATTERN.matcher(input).find()) {
                throw new IllegalArgumentException("커스텀 구분자는 문자열의 시작 부분에만 위치해야 합니다.");
            }
            return customDelimiters;
        }

        String remainingInput = input;

        do {
            Matcher matcher = PATTERN.matcher(remainingInput);
            if (!matcher.find()) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            String customDelimiter = matcher.group(1);
            customDelimiters.add(customDelimiter);
            remainingInput = remainingInput.substring(matcher.end());

        } while (remainingInput.startsWith("//"));

        if (PATTERN.matcher(remainingInput).find()) {
            throw new IllegalArgumentException("커스텀 구분자는 문자열의 시작 부분에만 위치해야 합니다.");
        }

        return customDelimiters;
    }
}