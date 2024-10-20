package calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {

    // 기본 구분자 (쉼표, 콜론)
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 입력 문자열에서 숫자를 추출하고, 해당 숫자들을 리스트로 반환
    public List<Integer> parseNumbers(String input) {
        if (isInputEmpty(input)) {
            return List.of(0);
        }

        // 커스텀 구분자 처리
        String delimiters = DEFAULT_DELIMITERS;
        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            input = extractNumbers(input);
        }

        return parseTokens(input, delimiters);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // 커스텀 구분자를 추출하는 메서드
    private String extractCustomDelimiter(String input) {
        Validator.validateCustomDelimiterFormat(input);
        int delimiterEndIndex = input.indexOf("\\n");
        return Pattern.quote(input.substring(2, delimiterEndIndex));
    }

    // 숫자 추출하는 메서드
    private String extractNumbers(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        return input.substring(delimiterEndIndex + 2);
    }

    // 기본 구분자와 커스텀 구분자로 분리된 숫자 추출
    private List<Integer> parseTokens(String numbers, String delimiters) {
        String[] tokens = numbers.split(delimiters);

        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                Validator.validateNumber(token);
                result.add(Integer.parseInt(token));
            }
        }

        return result;
    }
}