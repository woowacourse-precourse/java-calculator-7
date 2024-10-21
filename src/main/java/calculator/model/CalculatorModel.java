package calculator.model;


import calculator.exception.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CalculatorModel {

    private static final String DEFAULT_DELIMITER_REGEX = "^(|([1-9][0-9]*([,:][1-9][0-9]*)*))$";
    private static final String CUSTOM_DELIMITER_REGEX = "^//([^0-9]*)\\\\n(|([1-9][0-9]*(\\1[1-9][0-9]*)*))$";

    // 기본 구분자와 커스텀 구분자 구분하기
    public boolean checkCustomDelimiter(String str) {
        return str.startsWith("//");
    }

    // 구분자 검증하기
    public String[] validateDelimiter(boolean isCustom, String str) {
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
        throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getErrorMessage());
    }

    // 커스텀 구분자 검증
    private static String[] validateCustomDelimiter(String str) {
        Matcher matcher = regexMatcher(str, CUSTOM_DELIMITER_REGEX);
        if (matcher.matches()) {
            return new String[]{Pattern.quote(matcher.group(1)), matcher.group(2)};
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getErrorMessage());
    }

    // 정규식 매처 생성
    private static Matcher regexMatcher(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str);
    }

    // 덧셈 기능
    public int sum(String delimiter, String numberFormula) {
        if (numberFormula.isEmpty()) {
            return 0;
        }

        String[] numberArray = numberFormula.split(delimiter);
        int result = 0;
        for (String number : numberArray) {
            result += Integer.parseInt(number);
        }
        return result;
    }

}
