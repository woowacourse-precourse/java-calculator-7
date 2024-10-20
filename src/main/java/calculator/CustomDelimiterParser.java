package calculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private String regex = "^//(.*?)\\\\n";
    private String input;

    public CustomDelimiterParser(String input) {
        this.input = input;
    }

    public Optional<String> getCustomDelimiter() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find())
            return Optional.empty();

        String customDelimiter = matcher.group(1);

        if(customDelimiter.length() > 1)
            throw new IllegalArgumentException("커스텀 구분자는 1자리여야 합니다.");

        return Optional.of(customDelimiter);
    }

    public String getRemainingInput() {
        return input.replaceFirst(regex, "");  // 커스텀 구분자 부분 제거
    }
}
