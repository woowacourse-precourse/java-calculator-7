package calculator.service;

import java.util.HashSet;
import java.util.Set;

public class CalculatorService {
    private final Set<String> separators = new HashSet<>();

    public int strCalculator(String input) {
        String processedInput = customSplit(input);
        return extractNumber(processedInput);
    }

    /* 구분자 추출 과정 */
    public String customSplit(String input) {
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

        separators.add(",");
        separators.add(":");

        return input;
    }

    /* 숫자 추출 과정 */
    public int extractNumber(String input) {
        int sum = 0;

        String[] numbers = input.split("[" + String.join("", separators) + "]");

        for (String numberStr : numbers) {
            numberStr = numberStr.trim();

            if (!numberStr.isEmpty()) {
                try {
                    sum += Integer.parseInt(numberStr);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return sum;
    }
}
