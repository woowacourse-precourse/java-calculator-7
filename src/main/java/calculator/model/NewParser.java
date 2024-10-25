package calculator.model;

public class NewParser {
    public static int sum(String inputString) {

        int sum = 0;
        String[] operands = inputString.split(",|:");

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }

        return sum;
    }
}
