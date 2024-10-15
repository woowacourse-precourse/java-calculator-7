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

        // 그룹에서 커스텀 구분자와 숫자 부분 추출
        String customDelimeter = matcher.group(1);
        String numbersPart = matcher.group(2);

        return splitAndConvert(numbersPart, customDelimeter);
    }

    // 기본 구분자 파싱
    public static List<Integer> parseWithDefaultDelimeter(String input) {
        String joinedDelimeter = String.join("|", DEFAULT_DELIMITERS);
        return splitAndConvert(input, joinedDelimeter);
    }

    // 입력 문자열 중 숫자만 파싱
    private static List<Integer> splitAndConvert(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}