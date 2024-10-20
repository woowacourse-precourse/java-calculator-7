package calculator.model;

import java.util.regex.Pattern;

public class Validator {

    private final Parser parser;

    public Validator() {
        this.parser = new Parser();
    }

    public int[] validateAndParse(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new int[0];
        }

        expression = expression.trim().replace("\\n", "\n");

        String delimiter = ",|:";
        String numbers = expression;

        if (expression.startsWith("//")) {
            int delimiterEndIdx = expression.indexOf("\n");
            if (delimiterEndIdx == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다: " + expression);
            }

            String customDelimiter = expression.substring(2, delimiterEndIdx);
            if (customDelimiter.matches("\\d+")) {
                throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다: " + customDelimiter);
            }

            // 정규 표현식에서 메타문자들을 이스케이프 처리하기 위해 Pattern.quote 사용
            customDelimiter = Pattern.quote(customDelimiter);

            delimiter = delimiter + "|" + customDelimiter;
            numbers = expression.substring(delimiterEndIdx + 1);
        }

        return parser.parseNumbersFromExpression(numbers, delimiter);
    }
}
