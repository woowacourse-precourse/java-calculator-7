package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationString {
    private final String value;

    public CalculationString(String calculationString) {
        this.value = calculationString;
    }

    public List<SumValue> getSumValues(CustomDelimiter customDelimiter) {
        String splitRegex = ":|,";

        if (customDelimiter != null) {
            splitRegex = splitRegex + "|" + customDelimiter.getCustomDelimiter();
        }

        return Arrays.stream(value.split(splitRegex))
                .map(str -> stringToInteger(str))
                .map(SumValue::new)
                .collect(Collectors.toList());
    }

    private int stringToInteger(String str) { //TODO
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
