package calculator.model;

public class Calculator {

    private final int result;

    public Calculator(ExpressionParser expressionParser) {
        this.result = calculateExpression(expressionParser);
    }

    public int getResult(){
        return result;
    }

    public int calculateExpression(ExpressionParser expressionParser){
        return expressionParser.stringToIntegerList().stream().
            mapToInt(Integer::intValue)
            .sum();
    }
}
