package calculator.service;

import calculator.util.StringValidator;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CalculatorService {
    private final Set<String> separators = new HashSet<>(Set.of(",", ":"));

    public int strCalculator(String input) {
        return extractNumber(customSplit(input));
    }

    /* 구분자 추출 과정 */
    private String customSplit(String input) {
        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int separatorIndex = input.indexOf("\n");

            if (separatorIndex == -1) {
                throw new IllegalArgumentException();
            }

            String separator = input.substring(2, separatorIndex);

            for (char c : separator.toCharArray()) {
                separators.add(String.valueOf(c));
            }

            input = input.substring(separatorIndex + 1);
        }

        return input;
    }

    /* 숫자 추출 과정 */
    private int extractNumber(String input) {
        StringTokenizer st = new StringTokenizer(input, String.join("", separators));

        int sum = 0;

        while (st.hasMoreTokens()) {
            String numberStr = st.nextToken();

            if (!StringValidator.isNumeric(numberStr)) {
                throw new IllegalArgumentException();
            }

            sum += Integer.parseInt(numberStr);
        }

        return sum;
    }
}
