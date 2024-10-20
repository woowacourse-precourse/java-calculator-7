package calculator.service;

public class CalculatorService {
    private String[] tokens;

    public void separate(String[] separators, String expression) {
        String cleanedExpression = expression.replaceAll("\\s+", "");
        this.tokens = cleanedExpression.split(String.join("|", separators));
    }

}
