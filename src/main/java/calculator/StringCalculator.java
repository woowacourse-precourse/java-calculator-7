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

    public String extractDelimiter(List<String> splitString) {
        String delimiterCandidates = splitString.getFirst();

        if (delimiterCandidates.isEmpty()) {
            return null;
        }

        return delimiterCandidates.substring(2);
    }

    public List<Double> extractNumbersByDelimiter(List<String> splitString, String customDelimiter) {
        String numberCandidates = splitString.get(1);
        NumberValidator numberValidator = new NumberValidator();
        List<String> splitNumber = Arrays.stream(numberCandidates.split(",|:|" + customDelimiter)).toList();

        numberValidator.validate(splitNumber);

        return splitNumber.stream().map(number -> number.isBlank() ? 0.0 : Double.parseDouble(number)).toList();
    }

    public Double calculate(List<Double> numberList) {
        return numberList.stream().mapToDouble(Double::doubleValue).sum();
    }
}
