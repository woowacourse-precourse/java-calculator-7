package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.Extractor.extractDelimiter;
import static calculator.Extractor.extractNumberPart;

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
        delimiter = extractDelimiter(value, delimiter, prefix, suffix);
        String numberPart = extractNumberPart(value, prefix, suffix);
        return splitNumbers(numberPart);
    }

    private int convertToNumber(String value) {
        String trimmedValue = value.trim();
        if (trimmedValue.isEmpty()) return 0;
        return Integer.parseInt(trimmedValue);
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
