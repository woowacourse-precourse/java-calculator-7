package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    public String[] split(String input) {
        StringBuilder delimiter = new StringBuilder(DEFAULT_DELIMITERS);

        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            System.out.println("d" + customDelimiter);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 입력되지 않았습니다.");
            }
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 합니다.");
            }

            delimiter.append("|").append(Pattern.quote(customDelimiter));
            input = matcher.replaceFirst("");
        }

        return input.split(delimiter.toString());
    }
}
