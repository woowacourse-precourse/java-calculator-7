package calculator.domain.separator;

import calculator.domain.number.Number;
import java.util.Arrays;
import java.util.List;

public class CustomSeparator implements Separator {

    private static final String PREFIX_STANDARD = "\\n";
    private final String separator;

    public CustomSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public List<Number> separate(String input) {
        String value = removePrefix(input);

        if (hasSeparatorIn(value)) {
            return convert(validateSeparator(value));
        }

        return List.of(new Number(value));
    }

    private String removePrefix(String value) {
        return value.substring(
                value.indexOf(PREFIX_STANDARD) + PREFIX_STANDARD.length());
    }

    private List<String> divideBySeparator(String value) {
        return Arrays.stream(value.split(separator)).toList();
    }

    private List<Number> convert(List<String> values) {
        return values.stream()
                .map(Number::new)
                .toList();
    }

    private List<String> validateSeparator(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return divideBySeparator(value);
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

    private boolean hasSeparatorIn(String value) {
        return value.contains(separator);
    }
}
