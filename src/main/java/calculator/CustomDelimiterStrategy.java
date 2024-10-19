package calculator;

import java.util.HashSet;
import java.util.Set;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final String[] customDelimiter;

    public CustomDelimiterStrategy(String customDelimiter) {
        this.customDelimiter = parseDelimiter(customDelimiter);
    }

    @Override
    public String[] split(String input) {
        // 입력 문자열에 해당 구분자가 있는 경우
        // 구분자를 임시로 모두 ','로 대체 (임시 통일 구분자)
        for (String delimiter : customDelimiter) {
            if (input.contains(delimiter)) {
                input = input.replace(delimiter, ",");
            }
        }
        String[] tokens = input.split(",");
        validateAndParseNumbers(tokens);
        return tokens;
    }

    private void validateAndParseNumbers(String[] tokens) {
        for (String token : tokens) {

            if (token.isEmpty()) {
                throw new IllegalArgumentException("구분자가 연속으로 입력되었습니다.");
            }

            try {
                double number = Double.parseDouble(token);

                if (number <= 0) {
                    throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + token);
                }

                if (number != (int) number) {
                    throw new IllegalArgumentException("소수는 허용되지 않습니다: " + token);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + token);
            }
        }
    }

    private String[] parseDelimiter(String delimiter) {
        String[] customs = delimiter.split("");

        Set<String> uniqueDelimiters = new HashSet<>();

        //기본 구분자 set에 추가
        uniqueDelimiters.add(",");
        uniqueDelimiters.add(":");

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
                throw new IllegalArgumentException("사용할 수 없는 구분자가 있습니다: " + custom);
            }
        }
        return customs;
    }
}
