package calculator.extractor.developed;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardDelimiterNumberExtractor implements DelimitedNumberExtractor {
    private static final String STANDARD_DELIMITERS = ",|:";

    @Override
    public ExtractResult extract(String input) {
        if (input.isEmpty()) {
            return new ExtractResult(true, Arrays.asList("0"));
        }
        if (!input.contains(",") && !input.contains(":")) {
            return new ExtractResult(false, List.of());
        }
        List<String> numbers = Arrays.stream(input.split(STANDARD_DELIMITERS))
                .filter(this::isNumber)
                .collect(Collectors.toList());
        return new ExtractResult(true, numbers);
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


