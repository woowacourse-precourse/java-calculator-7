package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    // 기본 구분자 검증 함수
    private static String validateDefaultDelimiter(String formula) {
        Pattern pattern = Pattern.compile("^([1-9][0-9]*([,:][1-9][0-9]*)*)$");
        Matcher matcher = pattern.matcher(formula);

        if (matcher.matches()) {
            return matcher.group(1);
        }
        System.out.println("잘못된 사용자 입력입니다.");
        return "";
    }

    // 커스텀 구분자 검증 함수
    private static String[] validateCustomDelimiter(String formula) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n(|([1-9][0-9]*(\\1[1-9][0-9]*)*))$");
        Matcher matcher = pattern.matcher(formula);
        if (matcher.matches()) {
            return new String[] {matcher.group(1), matcher.group(2)};
        } else {
            System.out.println("잘못된 사용자 입력입니다.");
            return new String[] {};
        }
    }

    static String[] validateDelimiter(boolean iscustomDelimiter, String formula) {
        if (iscustomDelimiter) {
            return validateCustomDelimiter(formula);
        }
        return validateDefaultDelimiter(formula);
    }

}
