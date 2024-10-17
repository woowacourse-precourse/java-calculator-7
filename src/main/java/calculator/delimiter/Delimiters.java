package calculator.delimiter;

import java.util.Arrays;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(join("|"))).toList();
    }

    private String join(String delimiter) {
        return String.join(delimiter, delimiters.stream().map(Delimiter::value).toList());
    }
}
