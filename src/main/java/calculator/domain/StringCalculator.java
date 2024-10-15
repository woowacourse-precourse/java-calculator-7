package calculator.domain;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DISTINGUISHED = "[,;]";

    public String extractCustom(String value) {
        return value.substring(2, 3);
    }

    public String removeValue(String value) {
        return value.substring(5);
    }

    public String[] createNewValue(String removeAfterValue) {
        return removeAfterValue.split("");
    }

    public List<Integer> saveValue(String[] newValue) {
        return Arrays.stream(newValue)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int calculateSum(List<Integer> calculationValue) {
        return calculationValue.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public String[] separatorValue(String value) {
        return value.split(DISTINGUISHED);
    }


}
