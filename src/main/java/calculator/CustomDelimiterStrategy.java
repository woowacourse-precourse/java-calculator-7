package calculator;

import java.util.HashSet;
import java.util.Set;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final String[] customDelimiter;

    public CustomDelimiterStrategy(String customDelimiter) {
        this.customDelimiter = parseCustomDelimiter(customDelimiter);
    }

    @Override
    public String[] split(String input) {
        input = DelimiterStrategyUtil.replaceDelimiters(input, customDelimiter);
        String[] tokens = input.split(",");
        DelimiterStrategyUtil.validateAndParseNumbers(input, tokens);
        return tokens;
    }

    private String[] parseCustomDelimiter(String delimiter) {
        String[] customs = delimiter.split("");

        Set<String> uniqueDelimiters = new HashSet<>();

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
            if (!uniqueDelimiters.add(custom) && !custom.equals(",") && !custom.equals(":")) {
                throw new IllegalArgumentException("중복된 구분자가 있습니다: " + custom);
            }

            if (custom.equals("-") || custom.equals("+")) {
                throw new IllegalArgumentException("사용할 수 없는 구분자가 있습니다: " + custom);
            }
        }
        uniqueDelimiters.add(":");
        uniqueDelimiters.add(",");

        return uniqueDelimiters.toArray(new String[0]);
    }
}
