package calculator.model.delimiter.factory;

import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultDelimitersFactory extends DelimitersFactory {

    private final List<Delimiter> defaultDelimiters = List.of(
            new Delimiter(","),
            new Delimiter(":")
    );

    public List<Delimiter> getDefaultDelimiters() {
        return List.copyOf(defaultDelimiters);
    }


    @Override
    public Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        List<Delimiter> delimiters = new ArrayList<>(defaultDelimiters);
        delimiters.addAll(Arrays.asList(additionalDelimiters));
        return new Delimiters(delimiters);
    }
}
