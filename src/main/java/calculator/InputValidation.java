package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    // 기본 구분자 검증 함수
    private static String[] validateDefaultDelimiter(String formula) {
        Pattern pattern = Pattern.compile("^(|([1-9][0-9]*([,:][1-9][0-9]*)*))$");
        Matcher matcher = pattern.matcher(formula);
        if (matcher.matches()) {
            return new String[]{"[,:]", matcher.group(1)};
        }
        throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
    }

    // 커스텀 구분자 검증 함수
    private static String[] validateCustomDelimiter(String formula) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n(|([1-9][0-9]*(\\1[1-9][0-9]*)*))$");
        Matcher matcher = pattern.matcher(formula);
        if (matcher.matches()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
    }

    static String[] validateDelimiter(boolean isCustomDelimiter, String formula) {
        if (isCustomDelimiter) {
            return validateCustomDelimiter(formula);
        }
        return validateDefaultDelimiter(formula);
    }

}
