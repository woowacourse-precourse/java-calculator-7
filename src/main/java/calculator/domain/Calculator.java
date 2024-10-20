package calculator.domain;

public class Calculator {
    private String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }

    private String[] getStrNumbers() {
        processDelimiters();
        return expression.split(",");
    }


    private void processDelimiters() {
        replaceBasicDelimiters();
        replaceCustomDelimiter();
    }

    // 모든 : 를 , 로 변경
    private void replaceBasicDelimiters() {
        expression = expression.replaceAll(":", ",");
    }

    // //와 \n 사이의 문자열을 ,로 변경
    private void replaceCustomDelimiter() {
        if (expression.contains("//")) {
            int startIdx = expression.indexOf("//");
            int endIdx = expression.indexOf("\\n");

            String customDelimiter = expression.substring(startIdx + 2, endIdx);

            String beforeCustomDelimiter = expression.substring(0, startIdx);
            String afterCustomDelimiter = expression.substring(endIdx + 2);

            expression = (beforeCustomDelimiter + afterCustomDelimiter)
                    .replaceAll(customDelimiter, ",");
        }
    }

    public int calculate() {
        String[] strNumbers = getStrNumbers();
        int sum = 0;
        for (String strNumber : strNumbers) {
            sum += Integer.parseInt(strNumber);
        }
        return sum;
    }
}
