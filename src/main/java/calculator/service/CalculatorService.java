package calculator.service;

import java.util.HashSet;
import java.util.Set;

public class CalculatorService {
    private final Set<String> separators = new HashSet<>();

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


}
