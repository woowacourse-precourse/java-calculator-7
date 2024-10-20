package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberExtractor {

    public List<Integer> extractNumbers(DelimiterAndNumber delimiterAndNumber) {
        delimiterAndNumber.validateStart();
        String[] splitNumbers = delimiterAndNumber.splitNumbers();
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }
}
