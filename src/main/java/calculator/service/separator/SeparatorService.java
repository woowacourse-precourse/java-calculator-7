package calculator.service.separator;

import calculator.domain.separator.BasicSeparator;
import calculator.domain.separator.CustomSeparator;
import calculator.domain.separator.Separator;
import java.util.Arrays;
import java.util.List;

public class SeparatorService {

    private static final String PREFIX_CUSTOM_SEPARATOR = "//";
    private static final String SUFFIX_CUSTOM_SEPARATOR = "\\\\n";

    public List<String> separate(String input) {
        return divideNumber(generate(input), input);
    }

    private List<String> divideNumber(Separator separator, String value) {
        return separator.separate(value);
    }

    private Separator generate(String input) {
        if (hasCustomSeparator(input)) {
            return new CustomSeparator(extractCustomSeparatorIn(input));
        }

        return new BasicSeparator();
    }

    private String extractCustomSeparatorIn(String input) {
        return Arrays.stream(input.split(SUFFIX_CUSTOM_SEPARATOR))
                .filter(part -> part.contains(PREFIX_CUSTOM_SEPARATOR))
                .map(part -> part.substring(
                        part.indexOf(PREFIX_CUSTOM_SEPARATOR)
                                + PREFIX_CUSTOM_SEPARATOR.length()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasCustomSeparator(String value) {
        return value.startsWith(PREFIX_CUSTOM_SEPARATOR);
    }
}
