package calculator.delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterFactory {

    private static final List<Delimiter> DEFAULT_DELIMITERS = List.of(
            new Delimiter(","),
            new Delimiter(":")
    );

    public static Delimiters createDelimiters(Delimiter... delimiter) {
        List<Delimiter> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        delimiters.addAll(Arrays.asList(delimiter));
        return new Delimiters(delimiters);
    }
}
