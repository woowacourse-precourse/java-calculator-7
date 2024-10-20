package calculator.service;

import calculator.util.CustomStringUtils;
import calculator.util.SeparatorUtils;
import java.util.StringTokenizer;

public class CalculatorService {

    public int calculate(String input) {
        String operand = SeparatorUtils.parseSeparators(input);
        String operation = String.join("", SeparatorUtils.getSeparators());

        return addOperation(operand, operation);
    }

    private int addOperation(String operand, String operation) {
        StringTokenizer st = new StringTokenizer(operand, operation);

        int sum = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (!CustomStringUtils.isNumeric(token)) {
                throw new IllegalArgumentException("연산자가 아닌 값이 포함되어 있습니다.");
            }

            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
