package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculateExpression {

    private final String expression;
    private final List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    private CalculateExpression(String expression) {
        String customDelimiter = this.parseCustomDelimiter(expression);
        if (customDelimiter != null) {
            this.delimiters.add(Pattern.quote(customDelimiter));
            expression = this.removeCustomDelimiterPrefix(expression);
        }

        this.expression = expression;
    }

    public static CalculateExpression fromString(String expression) {
        return new CalculateExpression(expression);
    }

    public String getExpression() {
        return this.expression;
    }

    public List<String> getDelimiters() {
        return this.delimiters;
    }

    /**
     * 숫자와 구분자로 이루어진 문자열에서 커스텀 구분자를 찾는다.
     *
     * @param expression 숫자와 구분자로 이루어진 문자열
     * @return 커스텀 구분자를 찾으면 커스텀 구분자, 없다면 null
     */
    private String parseCustomDelimiter(String expression) {
        if (expression.startsWith("//")) {
            return expression.split("//")[1].split("\\\\n")[0];
        }

        return null;
    }

    /**
     * 커스텀 구분자를 사용하기 위한 표현(//${커스텀 문자}\n)을 제거한다.
     *
     * @param expression 커스텀 구분자 표현이 포함된 문자열
     * @return 커스텀 구분자 표현이 제거된 문자열
     */
    private String removeCustomDelimiterPrefix(String expression) {
        return expression.split("\\\\n")[1];
    }
}
