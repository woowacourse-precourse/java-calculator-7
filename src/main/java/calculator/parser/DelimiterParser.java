package calculator.parser;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import calculator.validator.DelimiterValidator;
import java.util.regex.Pattern;

public class DelimiterParser {

    private final DelimiterValidator delimiterValidator;

    public DelimiterParser(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public String[] parse(String input) {
        if (input.startsWith("//")) {
            String[] parts = splitInput(input);
            String customDelimiter = parts[0].substring(2);
            delimiterValidator.validateCustomDelimiter(customDelimiter);
            return splitByDelimiter(parts[1], customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    private String[] splitInput(String input) {
        input = input.replace("\\n", "\n");
        String[] parts = input.split("\n", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 계산 될 문자가 없습니다.");
        }
        return parts;
    }

    private String[] splitByDelimiter(String input, String delimiter) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }

        if (!input.contains(delimiter)) {
            return new String[]{input};
        }
        return input.split(Pattern.quote(delimiter));
    }
}
