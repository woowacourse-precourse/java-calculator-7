package calculator;

public class PlusCalculator {

    private PlusCalculator() {}

    public static int calculate(String input) {
        String separatorRegex = CalculatorUtil.getSeparatorRegex(input);
        String expression = CalculatorUtil.getExpression(input);
        String[] operands = expression.split(separatorRegex);
        int result = 0;
        for (String operand : operands) {
            if (operand.length() != 0)
                result += Integer.parseInt(operand);
        }

        return result;
    }

}
