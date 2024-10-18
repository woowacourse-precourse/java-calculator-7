package calculator.extractor;

import java.util.Arrays;
import java.util.List;

public class DefaultTokenExtractor implements TokenExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    @Override
    public List<String> extract(String input) {
        return Arrays.asList(input.split(DEFAULT_DELIMITERS));
    }
}
