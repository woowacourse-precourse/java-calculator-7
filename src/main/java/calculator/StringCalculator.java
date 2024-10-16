package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public List<String> splitDelimiterAndNumbers(String formula) {
        if (formula.startsWith("//") && formula.contains("\\n")) {
            String[] split = formula.split("\\\\n");

            return List.of(split);
        }

        return List.of("", formula);
    }

    public String extractDelimiter(String delimiterCandidates) {
        if (delimiterCandidates.isEmpty()) {
            return null;
        }

        return delimiterCandidates.substring(2);
    }

    public List<Double> splitNumbersByDelimiter(String numberCandidates, String customDelimiter) {
        String[] splitNumber = numberCandidates.split(",|:|" + customDelimiter);

        return Arrays.stream(splitNumber).map(Double::parseDouble).toList();
    }
}
