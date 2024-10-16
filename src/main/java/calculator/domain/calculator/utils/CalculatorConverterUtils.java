package calculator.domain.calculator.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class CalculatorConverterUtils {

    private static final String BASIC_SEPARATOR_REGEX = "[,:]";

    public static List<BigInteger> convert(String input) {
        String[] arrays = input.split(BASIC_SEPARATOR_REGEX);

        return Arrays.stream(arrays)
                .map(BigInteger::new)
                .toList();
    }
}
