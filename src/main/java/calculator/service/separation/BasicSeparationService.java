package calculator.service.separation;

import calculator.domain.Number;
import calculator.domain.Numbers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSeparationService implements SeparationService {

    private static final String BASIC_SEPARATOR_REGEX = "[,:]";

    @Override
    public boolean hasCustomSeparator(String input) {
        return false;
    }

    @Override
    public Numbers getNumbers(String input, String... separators) {

        String[] split = split(input, BASIC_SEPARATOR_REGEX);
        List<Number> values = Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::from)
                .collect(Collectors.toList());

        return Numbers.from(values);
    }
}
