package calculator.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // 기본 구분자 (쉼표와 콜론)
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        // 기본 구분자에 대한 정규식
        String defaultRegex = "^\\d+([,:]\\d+)*$";

        // 커스텀 구분자에 대한 정규식 (\\n은 이스케이프 처리)
        String customDelimiterRegex = "^//(.*?)\\\\n(.*)";

        Matcher defaultMatcher = Pattern.compile(defaultRegex).matcher(input);
        Matcher customMatcher = Pattern.compile(customDelimiterRegex).matcher(input);

        // 기본 정규식이나 커스텀 구분자가 모두 일치하지 않으면 예외 발생
        if (!defaultMatcher.matches() && !customMatcher.matches()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }

        // 커스텀 구분자를 사용할 경우 처리
        if (customMatcher.matches()) {
            validateCustomDelimiterInput(input, customMatcher);
        } else {
            validateDefaultDelimiterInput(input);
        }
    }

    private static void validateCustomDelimiterInput(String input, Matcher matcher) {
        String delimiter = matcher.group(1); // 커스텀 구분자 추출
        String targetString = matcher.group(2); // 숫자 부분 추출

        if(delimiter.isEmpty() || delimiter.isBlank()) throw new IllegalArgumentException("구분자가 없습니다.");

        // 커스텀 구분자를 제외한 다른 특수문자가 있는지 검사
        validateSpecialCharacters(targetString, delimiter);
        validateMinusNums(targetString, delimiter);
    }

    // 기본 구분자 검증
    private static void validateDefaultDelimiterInput(String input) {
        String joinedDelimiter = String.join("|", DEFAULT_DELIMITERS);
        validateSpecialCharacters(input, joinedDelimiter);
        validateMinusNums(input, joinedDelimiter);
    }

    // 구분자를 제외한 특수문자 검증
    private static void validateSpecialCharacters(String targetString, String delimiter) {
        String regex = "[^0-9" + Pattern.quote(delimiter) + "]";
        Matcher matcher = Pattern.compile(regex).matcher(targetString);
        if (matcher.find()) {
            throw new IllegalArgumentException("유효하지 않은 특수문자가 포함되어 있습니다.");
        }
    }

    // 음수 검증
    private static void validateMinusNums(String input, String delimiter) {
        String escapedDelimiter = Pattern.quote(delimiter);
        String[] split = input.split(escapedDelimiter);

        for (String s : split) {
            boolean isMinus = Integer.parseInt(s) < 0;
            if (isMinus) {
                throw new IllegalArgumentException("음수가 포함되어 있습니다.");
            }
        }
    }
}