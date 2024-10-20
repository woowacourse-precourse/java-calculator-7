package calculator.domain;

import calculator.domain.vo.CustomValues;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DISTINGUISHED = "[,;]";

    private static final String BEGIN_DATA = "//";

    public CustomValues extractCustomValue(String value) {
        return getCustomValues(value);
    }

    public String removeValue(String value) {
        return getString(value);
    }

    public String[] createNewValue(String removeAfterValue, String separatorValue) {
        return removeAfterValue.split(separatorValue);
    }

    public List<Integer> saveValue(String[] newValue) {
        return getIntegers(newValue);
    }

    public int calculateSum(List<Integer> calculationValue) {
        return calculationValue.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> getIntegers(final String[] newValue) {
        return Arrays.stream(newValue)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }


    private CustomValues getCustomValues(final String value) {
        if (value.startsWith(BEGIN_DATA)) {
            return new CustomValues(value.substring(2, 3));
        }
        return new CustomValues(DISTINGUISHED);
    }

    private String getString(final String value) {
        if (value.startsWith(BEGIN_DATA)) {
            return value.substring(value.indexOf("n") + 1);
        }
        return value;
    }
}
