package calculator.numbercalculator.delimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    private static final List<Delimiter> DEFAULT_DELIMITERS = List.of(
            new Delimiter(","),
            new Delimiter(":")
    );

    private final List<Delimiter> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

    public void add(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public List<String> split(String str) {
        if (str.isEmpty()) {
            return List.of();
        }
        String regex = getRegex();
        return List.of(str.split(regex));
    }

    private String getRegex() {
        String joinedDelimiters = delimiters.stream()
                .map(Delimiter::value)
                .collect(Collectors.joining(""));

        return String.format("[%s]", joinedDelimiters);
    }
}
