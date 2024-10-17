package calculator.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionDTO {

    private static final String CUSTOM_DELIMITER_FORMAT = "//([^0-9]+)\\\\n";

    private String incorrectPattern = "[^:,.0-9]";
    private String delimiter = "[:,]";
    private String expression;

    public ExpressionDTO(String expression) {
        this.expression = expression;
        setCustomDelimiter();
    }

    private void setCustomDelimiter() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_FORMAT).matcher(expression);

        if (matcher.find() && expression.startsWith(matcher.group())) {
            // 정규표현식의 예약 문자에 해당되는 특수문자를 구분자로 사용하기 위한 밑작업
            String newDelimiter = matcher.group(1)
                    .replace("\\", "\\\\")
                    .replace("[", "\\[");
            this.expression = expression.replace(matcher.group(), "").trim();
            this.delimiter = delimiter.replace(":,", String.join("\\\\", newDelimiter));
            this.incorrectPattern = incorrectPattern.replace(":,", newDelimiter);
        }
    }

    public String getIncorrectPattern() {
        return incorrectPattern;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getExpression() {
        return expression;
    }
}
