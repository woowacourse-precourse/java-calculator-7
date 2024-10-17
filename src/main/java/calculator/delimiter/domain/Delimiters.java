package calculator.delimiter.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> values;

    public Delimiters(List<Delimiter> delimiters) {
        this.values = delimiters;
    }

    public List<String> split(String source) {
        return Arrays.stream(source.split(join("|"))).toList();
    }

    private String join(String delimiterString) {
        return String.join(delimiterString, values.stream().map(Delimiter::value).toList());
    }
}
