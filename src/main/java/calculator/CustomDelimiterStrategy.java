package calculator;

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
        // 개행문자를 기준으로 앞, 뒤로 나눈다.
        // 예를 들어, `//;\n1;2;3` 이 입력으로 들어오면 `//;`과 `1;2;3` 2개 파트로 나뉜다.
        String[] parts = input.split("\n", 2);
        return Arrays.asList(parts[1].split(Pattern.quote(customDelimiter)));
    }
}
