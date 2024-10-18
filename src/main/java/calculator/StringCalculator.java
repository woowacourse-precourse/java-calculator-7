package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public List<String> splitDelimiterAndNumbers(String formula) {
        if (formula.startsWith("//") && formula.contains("\\n")) {
            String[] split = formula.split("\\\\n", 2);

            return List.of(split);
        }

        return List.of("", formula);
    }

    public String extractDelimiter(List<String> splitString) {
        String delimiterCandidates = splitString.getFirst();

        if (delimiterCandidates.isEmpty()) {
            return "";
        }

        return delimiterCandidates.substring(2);
    }

    public List<Double> extractNumbersByDelimiter(List<String> splitString, String customDelimiter) {
        NumberValidator numberValidator = new NumberValidator();
        String numberCandidates = splitString.getLast();
        String splitRegex = createDelimiterRegex(customDelimiter);
        List<String> splitNumber = Arrays.stream(numberCandidates.split(splitRegex, -1)).toList();

        numberValidator.validate(splitNumber);

        return splitNumber.stream().map(number -> number.isEmpty() ? 0.0 : Double.parseDouble(number)).toList();
    }

    private String createDelimiterRegex(String customDelimiter) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

        if (!customDelimiter.isEmpty()) {
            delimiters.add(customDelimiter);
        }

        return String.join("|", delimiters);
    }

    public Double calculate(List<Double> numberList) {
        return numberList.stream().mapToDouble(Double::doubleValue).sum();
    }
}
