package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberExtractor {

    public List<Integer> extractNumbers(DelimiterNumberHandler delimiterNumberHandler) {
        delimiterNumberHandler.validateStart();
        String[] splitNumbers = delimiterNumberHandler.splitNumbers();
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }
}
