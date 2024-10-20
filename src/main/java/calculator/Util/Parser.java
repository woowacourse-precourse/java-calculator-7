package calculator.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    // 기본 구분자 (쉼표와 콜론)
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};

    // 커스텀 구분자 파싱
    public static List<Integer> parseWithCustomDelimeter(String input) {
        Matcher matcher = Pattern.compile("^//(.*?)\\\\n" + "(.*)").matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return splitAndConvert(matcher.group(2), matcher.group(1));
    }

    // 기본 구분자 파싱
    public static List<Integer> parseWithDefaultDelimeter(String input) {
        String joinedDelimiter = String.join("|", DEFAULT_DELIMITERS);
        return splitAndConvert(input, joinedDelimiter);
    }

    // 입력 문자열 중 숫자만 파싱
    private static List<Integer> splitAndConvert(String input, String delimiter) {
        String escapedDelimiter = Pattern.quote(delimiter);
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String token : input.split(escapedDelimiter)) {
                numbers.add(Integer.parseInt(token));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}