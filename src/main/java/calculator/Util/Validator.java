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
        if (input.startsWith("//")) {
            validateCustomDelimiterInput(input);
        } else {
            validateDefaultDelimiterInput(input);
        }
    }

    private static void validateCustomDelimiterInput(String input) {
        Matcher matcher = Pattern.compile("^//(.*?)\\\\n(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        String delimiter = matcher.group(1);
        String targetString = matcher.group(2);

        //계산식에 주어진 구분자를 제외한 다른 특수문자가 있으면 에러 발생
        validateSpecialCharacters(targetString, delimiter);
        validateMinusNums(targetString, delimiter);
    }

    //기본 구분자 검증
    private static void validateDefaultDelimiterInput(String input) {
        String joinedDelimiter = String.join("|", DEFAULT_DELIMITERS);
        validateSpecialCharacters(input, joinedDelimiter);
        validateMinusNums(input, joinedDelimiter);
    }

    //구분자를 제외한 특수문자 검증
    private static void validateSpecialCharacters(String targetString, String delimiter) {
        String regax = "[^0-9" + Pattern.quote(delimiter) + "]";
        Matcher matcher = Pattern.compile(regax).matcher(targetString);
        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    //양수 검증
    private static void validateMinusNums(String input, String delimiter) {
        String escapedDelimiter = Pattern.quote(delimiter);
        String[] split = input.split(escapedDelimiter);

        for (String s : split) {
            boolean isMinus = Integer.parseInt(s) < 0;
            if (isMinus) {
                throw new IllegalArgumentException();
            }
        }
    }
}