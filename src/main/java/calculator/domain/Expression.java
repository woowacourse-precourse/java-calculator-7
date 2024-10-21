package calculator.domain;

public class Expression {
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public boolean isNull(){
        if(expression == null || expression.isEmpty()){
            return true;
        }
        return false;
    }
}
