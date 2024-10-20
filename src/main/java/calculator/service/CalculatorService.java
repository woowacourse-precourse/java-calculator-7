package calculator.service;

import java.util.List;
import java.util.Map;

public class CalculatorService {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int extractAndCalculate(Map<String, String> extractedMap) {

        String delimiter = DEFAULT_DELIMITER +
                (extractedMap.get("customDelimiter") != null
                        ? "|" + extractedMap.get("customDelimiter") : "");

        List<String> values = List.of(extractedMap.get("calculateString").split(delimiter));
        return sum(values);
    }

    private static int sum(List<String> values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
