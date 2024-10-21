package calculator.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionDTO {

    private static final String CUSTOM_DELIMITER_FORMAT = "//([^0-9]+)\\\\n";
    private static final String DEFAULT_DELIMITER_FORMAT = ":,";

    private String incorrectDelimiter = "[^" + DEFAULT_DELIMITER_FORMAT + ".0-9]";
    private String delimiter = "[" + DEFAULT_DELIMITER_FORMAT + "]";
    private String expression;

    public ExpressionDTO(String input) {
        this.expression = input;
        initialize(input);
    }

    private void initialize(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_FORMAT).matcher(expression);

        if (matcher.find() && expression.startsWith(matcher.group())) {
            String newDelimiter = convertMetaLetterToRegular(matcher.group(1));
            this.expression = expression.replace(matcher.group(), "").trim();
            this.delimiter = delimiter.replace(":,", newDelimiter);
            this.incorrectDelimiter = incorrectDelimiter.replace(":,", newDelimiter);
        }
    }
    // 정규표현식의 예약 문자도 커스텀 구분자로 사용하기 위한 밑작업
    private String convertMetaLetterToRegular(String delimiter) {
        return delimiter.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("^", "\\^")
                .replace("]", "\\]");
    }

    public String getIncorrectDelimiter() {
        return incorrectDelimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getExpression() {
        return expression;
    }
}
