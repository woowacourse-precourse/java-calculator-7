package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private String delimiter;
    private String prefix;
    private String suffix;

    public Converter(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public List<Integer> convertNumbersFromString(String value) {
        return Arrays.stream(value.split(delimiter))
                .map(this::convertToNumber)
                .collect(Collectors.toList());
    }

    private int convertToNumber(String value) {
        String trimmedValue = value.trim();
        if (trimmedValue.isEmpty()) return 0;
        return Integer.parseInt(trimmedValue);
    }
}
