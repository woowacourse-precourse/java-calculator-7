package calculator.domain;

public class Calculator {

    private String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }

    public String[] getStrNumbers() {
        processDelimiters();
        return expression.split(":");
    }

    private void processDelimiters() {
        replaceBasicDelimiters();
        replaceCustomDelimiter();
    }

    private void replaceBasicDelimiters() {
        expression = expression.replaceAll(",", ":");
    }

    private void replaceCustomDelimiter() {
        if (expression.contains("//")) {
            int startIdx = expression.indexOf("//");
            int endIdx = expression.indexOf("\\n");

            String customDelimiter = expression.substring(startIdx + 2, endIdx);

            String beforeCustomDelimiter = expression.substring(0, startIdx);
            String afterCustomDelimiter = expression.substring(endIdx + 2);

            expression = (beforeCustomDelimiter + afterCustomDelimiter)
                    .replaceAll(customDelimiter, ":");
        }
    }

}
