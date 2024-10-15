package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser{

    private static final String REGEX = "//(.*?)\\\\n(.*?)";
    private String delimiter = "[:,]";
    private String expression;

    public StringParser(String expression) {
        this.expression = expression;
        setCustomDelimiter();
    }

    private void setCustomDelimiter() {
        Matcher matcher = Pattern.compile(REGEX).matcher(expression);
        if (matcher.find()) {
            this.expression = expression.replace(matcher.group(0), "");
            this.delimiter = matcher.group(1);
        }
    }

    @Override
    public List<String> parse() {
        return Arrays.stream(expression.split(delimiter)).toList();
    }
}
