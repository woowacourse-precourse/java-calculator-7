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
        // 정규식 패턴: "//"으로 시작하고, 그 뒤에 임의의 문자가 있으며, "\\n"으로 끝나는 패턴
        Matcher matcher = Pattern.compile("^//(.*?)\\\\n" +
                "(.*)").matcher(input);

        // 정규식이 일치하지 않으면 예외 발생
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        // 그룹에서 커스텀 구분자와 숫자 부분 추출
        String customDelimeter = matcher.group(1); // ";\" 부분 추출
        String numbersPart = matcher.group(2); // "1" 부분 추출

        System.out.println("customDelimeter = " + customDelimeter);

        // 숫자 부분을 파싱하고 결과 반환
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
        try{
            for (String token : tokens) {
                // 문자열을 정수로 변환하여 리스트에 추가
                numbers.add(Integer.parseInt(token));
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}