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
        delimiter = extractDelimiter(value);
        String numberPart = extractNumberPart(value);
        return splitNumbers(numberPart);
    }

    private int convertToNumber(String value) {
        String trimmedValue = value.trim();
        if (trimmedValue.isEmpty()) return 0;
        return Integer.parseInt(trimmedValue);
    }

    public String extractDelimiter(String value){
        if (value.startsWith(prefix)) {
            int delimiterIndex = value.indexOf(suffix);
            String customDelimiter = value.substring(prefix.length(), delimiterIndex);
            return addDelimiter(delimiter, customDelimiter);
        }
        return delimiter;
    }

    private String extractNumberPart(String value){
        if (value.startsWith(prefix)) {
            int delimiterIndex = value.indexOf(suffix);
            return value.substring(delimiterIndex + 2);
        }
        return value;
    }

    private List<Integer> splitNumbers(String numberPart) {
        return Arrays.stream(numberPart.split(delimiter))
                .map(this::convertToNumber)
                .collect(Collectors.toList());
    }

    private String addDelimiter(String existingDelimiters, String newDelimiter) {
        return existingDelimiters.substring(0, existingDelimiters.length() - 1) + newDelimiter + "]";
    }
}
