package calculator.model;

public class Validator {

    private final Parser parser;

    public Validator() {
        this.parser = new Parser();
    }

    public int[] validateAndParse(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new int[0];
        }

        expression = expression.trim().replaceAll("\\\\n", "\n");

        String delimiter = ",|:";
        String numbers = expression;

        if (expression.startsWith("//")) {
            int delimiterEndIdx = expression.indexOf("\n");
            if (delimiterEndIdx == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다: " + expression);
            }
            delimiter = expression.substring(2, delimiterEndIdx);
            numbers = expression.substring(delimiterEndIdx + 1);
        }

        return parser.parseNumbersFromExpression(numbers, delimiter);
    }
}
