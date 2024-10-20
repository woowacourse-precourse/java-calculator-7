package calculator.service.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherUtil {
    public String match(String regularExpression, String inputString) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("예상하지 못한 잘못된 입력입니다.");
    }
}
