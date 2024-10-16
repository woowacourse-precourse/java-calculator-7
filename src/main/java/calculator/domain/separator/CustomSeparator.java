package calculator.domain.separator;

import java.util.Arrays;
import java.util.List;

public class CustomSeparator implements Separator {

    private static final String PREFIX_STANDARD = "\\n";
    private final String separator;

    public CustomSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public List<String> separate(String value) {
        return convert(validate(removePrefix(value)));
    }

    private String removePrefix(String value) {
        return value.substring(
                value.indexOf(PREFIX_STANDARD) + PREFIX_STANDARD.length());
    }

    private List<String> convert(String value) {
        if (hasSeparatorIn(value)) {
            return Arrays.stream(value.split(separator))
                    .toList();
        }

        return List.of(value);
    }

    private boolean hasSeparatorIn(String value) {
        return value.contains(separator);
    }

    private String validate(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return value;
    }

    private void validateEdgeSeparator(String value) {
        if (hasEdgeSeparator(value)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContinuousSeparator(String value) {
        if (isContinuousSeparator(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasEdgeSeparator(String value) {
        return value.startsWith(separator) || value.endsWith(separator);
    }

    private boolean isContinuousSeparator(String value) {
        return value.contains(separator.repeat(2));
    }
}
