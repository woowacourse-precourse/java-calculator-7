package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {

    // 기본 구분자 상수 정의
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 입력받은 문자열을 구분자와 양수로 구성된 문자열 List 로 분리함
    public List<String> parse(String input) {
        String delimiterPattern = DEFAULT_DELIMITERS;

        // 커스텀 구분자 정의 조건에 해당할 경우
        if (input.startsWith("//")) {

            // 커스텀 구분자 정의 종료 부분
            int delimiterEnd = input.indexOf("\\n");

            // 정의 부분을 제외한 커스텀 구분자
            String customDelimiter = input.substring(2, delimiterEnd);

            // 커스텀 구분자를 기본 구분자에 추가
            delimiterPattern = addCustomDelimiter(delimiterPattern, customDelimiter);

            // 커스텀 구분자 정의를 제외한 문자열
            input = input.substring((delimiterEnd + 2));
        }

        // 구분자를 기준으로 문자열을 분리
        return splitNumbers(input, delimiterPattern);
    }

    // 커스텀 구분자를 기본 구분자에 추가
    private String addCustomDelimiter(String defaultDelimiters, String customDelimiter) {
        return defaultDelimiters + "|" + Pattern.quote(customDelimiter);
    }

    // 구분자를 기준으로 문자열을 분리
    private List<String> splitNumbers(String input, String delimiterPattern) {
        String[] tokens = input.split(delimiterPattern);
        List<String> numbers = new ArrayList<>();
        Collections.addAll(numbers, tokens);
        return numbers;
    }
}
