package calculator.converter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class StringToBigIntegerListConverter {

    public List<BigInteger> convert(String input, List<String> delimiters) {
        String delimeterRegex = getDelimiterRegex(delimiters);
        String[] arrays = input.split(delimeterRegex);

        return Arrays.stream(arrays)
                .map(BigInteger::new)
                .toList();
    }

    private String getDelimiterRegex(List<String> delimiters) {
        return "[" + String.join("", delimiters) + "]";
    }
}
