package calculator.domain;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DISTINGUISHED = "[,;]";

    public String extractCustomValue(String value) {
        if (value.startsWith("//")) {
            return value.substring(2, 3);
        }
        return DISTINGUISHED;
    }

    public String removeValue(String value) {
        if (value.startsWith("//")) {
            return value.substring(5);
        }
        return value;
    }

    public String[] createNewValue(String removeAfterValue, String separatorValue) {
        return removeAfterValue.split(separatorValue);
    }

    public List<Integer> saveValue(String[] newValue) {
        return Arrays
                .stream(newValue)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int calculateSum(List<Integer> calculationValue) {
        return calculationValue.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
