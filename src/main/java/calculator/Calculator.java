package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {

    private static final String DEFAULT_DELIMITER_REGEX = "^(|([1-9][0-9]*([,:][1-9][0-9]*)*))$";
    private static final String CUSTOM_DELIMITER_REGEX = "^//([^0-9]*)\\\\n(|([1-9][0-9]*(\\1[1-9][0-9]*)*))$";

    // 문자열 입력 받기
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 기본 구분자와 커스텀 구분자 구분하기
    public static boolean checkCustomDelimiter(String str) {
        return str.startsWith("//");
    }

    // 구분자 검증하기
    public static String[] validateDelimiter(boolean isCustom, String str) {
        if (isCustom) {
            return validateCustomDelimiter(str);
        }
        return validateDefaultDelimiter(str);
    }

    // 기본 구분자 검증
    private static String[] validateDefaultDelimiter(String str) {
        Matcher matcher = regexMatcher(str, DEFAULT_DELIMITER_REGEX);
        if (matcher.matches()) {
            return new String[]{"[,:]", matcher.group(1)};
        }
        throw new IllegalArgumentException();
    }

    // 커스텀 구분자 검증
    private static String[] validateCustomDelimiter(String str) {
        Matcher matcher = regexMatcher(str, CUSTOM_DELIMITER_REGEX);
        if (matcher.matches()) {
            return new String[]{Pattern.quote(matcher.group(1)), matcher.group(2)};
        }
        throw new IllegalArgumentException();
    }

    // 정규식 매처 생성
    private static Matcher regexMatcher(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str);
    }

}
