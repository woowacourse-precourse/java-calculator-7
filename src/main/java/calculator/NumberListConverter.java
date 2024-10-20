package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberListConverter {

    public static List<PositiveNumber> toNumbers(String[] values) {
        try {
            return Arrays.stream(values)
                    .map(v -> new PositiveNumber(Integer.parseInt(v)))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
