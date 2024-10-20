package calculator.service.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public String findFirstGroup(String regularExpression, String inputString) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("예상하지 못한 잘못된 입력입니다.");   // \n이 없다면 혹은 그 외의 결과에 예외
    }
}
