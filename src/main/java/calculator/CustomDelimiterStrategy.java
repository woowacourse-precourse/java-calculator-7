package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterStrategy implements DelimiterStrategy{
    private static final Pattern customDelimiterRegex = Pattern.compile("^//([\\D]+)\\\\n(.*)$");

    @Override
    public boolean supports(String input) {
        return input.startsWith("//");
    }

    @Override
    public String[] split(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);
        if (matcher.matches()) {
            String delimiter = Pattern.quote(matcher.group(1));  // 커스텀 구분자 추출
            String numbers = matcher.group(2);  // 숫자 추출
            return numbers.split(delimiter);
        } else {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }
}
