package calculator.converter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class StringToPositiveIntegerListConverter {

    private final StringToBigIntegerConverter converter;

    public StringToPositiveIntegerListConverter() {
        this.converter = new StringToBigIntegerConverter();
    }

    public List<BigInteger> convert(String input, List<String> delimiters) {
        String delimeterRegex = getDelimiterRegex(delimiters);
        String[] arrays = input.split(delimeterRegex);

        return Arrays.stream(arrays)
                .map(converter::convert)
                .toList();
    }

    private String getDelimiterRegex(List<String> delimiters) {
        return "[" + String.join("", delimiters) + "]";
    }
}
