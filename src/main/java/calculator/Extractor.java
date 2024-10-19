package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private final String  patternRule = "//(.)\\\\n(.*)";

    public String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter.matches("[a-zA-Z0-9]")) {
                throw new IllegalArgumentException("특수문자만 가능합니다.");
            }
            return customDelimiter;
        }
        else {
            throw new IllegalArgumentException("커스텀 구분자의 올바른 형식이 아닙니다.");
        }
    }


    public String extractSentence(String input) {
        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
