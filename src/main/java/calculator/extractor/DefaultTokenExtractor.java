package calculator.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultTokenExtractor implements TokenExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";


    @Override
    public List<String> extract(String input) {
        if (input.isEmpty()) {
            return Arrays.asList("0");
        }
        return Arrays.stream(input.split(DEFAULT_DELIMITERS))
                .filter(this::isNumber)
                .collect(Collectors.toList());
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
