package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationString {
    private final String value;

    public CalculationString(String calculationString) {
        this.value = calculationString;
    }

    public SumValues getSumValues(Delimiters delimiters) {
        String regex = delimiters.convertToRegex();

        List<SumValue> sumValues = Arrays.stream(splitValueWithDelimiters(regex))
                .map(str -> stringToInteger(str))
                .map(SumValue::new)
                .collect(Collectors.toList());

        return new SumValues(sumValues);
    }

    private String[] splitValueWithDelimiters(String regex) {
        return value.split(regex);
    }

    private int stringToInteger(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자와 양수 이외 다른 문자는 입력x");
        }
    }
}
