package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final String customDelimiter;

    public CustomDelimiterStrategy(String customDelimiter) {
        this.customDelimiter = parseDelimiter(customDelimiter);
    }

    @Override
    public String[] split(String input) {
        return input.split(customDelimiter);
    }

    private String parseDelimiter(String delimiter) {
        String[] customs = delimiter.split("");

        Set<String> uniqueDelimiters = new HashSet<>();

        //기본 구분자 set에 추가
        uniqueDelimiters.add(".");
        uniqueDelimiters.add(";");

        StringBuilder result = new StringBuilder();
        for (String custom : customs) {
            // 구분자가 숫자인지 확인
            if (Character.isDigit(custom.charAt(0))) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다: " + custom);
            }

            // 구분자가 공백 문자인지 확인 (공백, 탭, 줄바꿈 등)
            if (Character.isWhitespace(custom.charAt(0))) {
                throw new IllegalArgumentException("공백 문자는 구분자로 사용할 수 없습니다: " + custom);
            }

            // 중복 구분자 확인
            if (!uniqueDelimiters.add(custom)) {
                throw new IllegalArgumentException("중복된 구분자가 있습니다: " + custom);
            }

            if (custom.equals("-") || custom.equals("+")) {
                throw new IllegalArgumentException("중복된 구분자가 있습니다: " + custom);
            }
            result.append(Arrays.toString(customs));
        }
        return result.toString();
    }
}
