package calculator;

import java.util.List;

public class StringCalculator {
    public List<String> splitDelimiterAndNumbers(String formula) {
        if (formula.startsWith("//") && formula.contains("\\n")) {
            String[] split = formula.split("\\\\n");

            return List.of(split);
        }

        return List.of("", formula);
    }
}
