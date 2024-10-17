package calculator.delimiter.factory;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterFactory {

    private static final List<Delimiter> DEFAULT_DELIMITERS = List.of(
            new Delimiter(","),
            new Delimiter(":")
    );

    public static Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        List<Delimiter> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        delimiters.addAll(Arrays.asList(additionalDelimiters));
        return new Delimiters(delimiters);
    }
}
