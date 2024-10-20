package calculator.domain;

import java.util.ArrayList;

public class Form {
    private final ArrayList<String> separator;
    private final String expression;

    public Form(ArrayList<String> separator, String expression) {
        this.separator = separator;
        this.expression = expression;
    }

    public ArrayList<String> getSeparator() {
        return separator;
    }

    public String getExpression() {
        return expression;
    }
}
