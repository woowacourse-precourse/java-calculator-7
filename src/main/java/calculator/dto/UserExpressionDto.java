package calculator.dto;

public class UserExpressionDto {
    private final String expression;

    public UserExpressionDto(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
