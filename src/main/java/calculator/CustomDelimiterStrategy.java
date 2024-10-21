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
        int numberStartIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                numberStartIndex = i + 2;
                break;
            }
        }
        String numberParts = input.substring(numberStartIndex);
        return Arrays.asList(numberParts.split(Pattern.quote(customDelimiter)));
    }
}
