package calculator.domain;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleCustomDelimiterParser {
    private String regex = "^//(.*?)\\\\n";
    private String input;

    public SingleCustomDelimiterParser(String input) {
        this.input = input;
    }

    public Optional<Delimiter> getCustomDelimiter() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find())
            return Optional.empty();

        String delimiterValue = matcher.group(1);
        Delimiter customDelimiter = new Delimiter(delimiterValue);
        customDelimiter.validate();

        return Optional.of(customDelimiter);
    }

    public String getRemainingInput() {
        return input.replaceFirst(regex, "");  // 커스텀 구분자 부분 제거
    }
}
