package calculator.model;

import java.util.Set;

abstract public class CalculatorModel {

    protected String input;
    protected String result;
    protected Set separators;
    protected String separatorExpression;
    protected String mathematicalExpression;

    abstract public void generateResult();

    public Set getSeparators() {
        return separators;
    }

    public String getSeparatorExpression() {
        return separatorExpression;
    }

    public String getMathematicalExpression() {
        return mathematicalExpression;
    }

    public void setSeparatorExpression(String separatorExpression) {
        this.separatorExpression = separatorExpression;
    }

    public void setMathematicalExpression(String mathematicalExpression) {
        this.mathematicalExpression = mathematicalExpression;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInput() {
        return this.input;
    }

    public String getResult() {
        return this.result;
    }


}
