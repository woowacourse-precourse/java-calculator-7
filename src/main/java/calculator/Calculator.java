package calculator;

import java.util.StringTokenizer;

public class Calculator {
    private final String delimiter1 = ",";
    private final String delimiter2 = ":";


    public Calculator() {};

    public int calculateResult(String input) {
        String delimeters = delimiter1 + delimiter2;
        if (input.startsWith("//")) {
            String[] delimeterAndExpression = checkCustomDelimeter(input);
            delimeters += delimeterAndExpression[0];
            return calculateSum(delimeterAndExpression[1], delimeters);
        }
        return calculateSum(input, delimeters);
    }

    private String[] checkCustomDelimeter(String input) {
        StringTokenizer st = new StringTokenizer(input.substring(2), "\\n");
        if (st.countTokens() != 2) {
            throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 정의");
        } else {
            String[] delimeterAndExpression = {st.nextToken(), st.nextToken()};
            return delimeterAndExpression;
        }
    }

    private int calculateSum(String expression, String delimeters) {
        StringTokenizer st = new StringTokenizer(expression, delimeters);
        int result = 0;
        while (st.hasMoreTokens()) {
            try {
                int delta = Integer.parseInt(st.nextToken());
                if (delta < 0) {
                    throw new IllegalArgumentException("음수 비허용");
                }
                result += delta;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정의되지 않은 구분자 사용");
            }
        }
        return result;
    }

}
