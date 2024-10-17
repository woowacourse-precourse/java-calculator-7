package calculator.delimiter;

import java.util.Arrays;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> values;

    public Delimiters(List<Delimiter> delimiters) {
        this.values = delimiters;
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(join("|"))).toList();
    }

    private String join(String delimiter) {
        return String.join(delimiter, values.stream().map(Delimiter::value).toList());
    }
}
