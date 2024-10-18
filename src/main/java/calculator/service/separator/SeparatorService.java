package calculator.service.separator;

import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
import calculator.domain.separator.BasicSeparator;
import calculator.domain.separator.CustomSeparator;
import calculator.domain.separator.Separator;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SeparatorService {

    private static final String PREFIX_CUSTOM_SEPARATOR = "//";
    private static final String SUFFIX_CUSTOM_SEPARATOR = "\\\\n";

    public Numbers separate(String input) {
        return new Numbers(divideNumber(generate(input), input));
    }

    private List<Number> divideNumber(Separator separator, String value) {
        return separator.separate(value);
    }

    private Separator generate(String input) {
        if (hasCustomSeparator(input)) {
            return new CustomSeparator(extractCustomSeparatorIn(input));
        }

        return new BasicSeparator();
    }

    private String extractCustomSeparatorIn(String input) {
        return extractSeparator(removePrefix(splitBySuffix(input)));
    }

    private String extractSeparator(Optional<String> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input.get();
    }

    private Optional<String> removePrefix(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(this::isPrefixIn)
                .map(value -> value.substring(PREFIX_CUSTOM_SEPARATOR.length()))
                .findFirst();
    }

    private String[] splitBySuffix(String input) {
        return input.split(SUFFIX_CUSTOM_SEPARATOR);
    }

    private boolean isPrefixIn(String input) {
        return input.contains(PREFIX_CUSTOM_SEPARATOR);
    }

    private boolean hasCustomSeparator(String value) {
        return value.startsWith(PREFIX_CUSTOM_SEPARATOR);
    }
}
