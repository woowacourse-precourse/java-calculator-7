package calculator.service;

import calculator.util.StringValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ParsingService {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private final StringValidator validator;

    public ParsingService() {
        this.validator = new StringValidator();
    }

    public List<String> parse(String input) {

        // 입력 유효성 검사
        validator.validate(input);

        // 문자열 파싱
        List<String> numbers = stringParse(input);

        // 파싱된 숫자 유효성 검사
        validator.validateNumbers(numbers);

        return numbers;
    }

    public List<String> stringParse(String input) {
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
