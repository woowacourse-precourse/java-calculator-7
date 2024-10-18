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

        if (!isBlank(value)) {
            return convert(validate(value)).stream()
                    .map(Number::new)
                    .toList();
        }

        return List.of(new Number(parse(value)));
    }

    private int parse(String value) {
        if (isBlank(value)) {
            return 0;
        }
        validateNumber(List.of(value));

        return Integer.parseInt(value);
    }

    private boolean isBlank(String value) {
        return value.isBlank();
    }

    private String removePrefix(String value) {
        return value.substring(
                value.indexOf(PREFIX_STANDARD) + PREFIX_STANDARD.length());
    }

    private List<String> divideBySeparator(String value) {
        return Arrays.stream(value.split(separator)).toList();
    }

    private List<Integer> convert(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private List<String> validate(String value) {
        List<String> values = validateSeparator(value);
        validateNumber(values);
        return values;
    }

    private List<String> validateSeparator(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return divideBySeparator(value);
    }

    private void validateNumber(List<String> values) {
        values.stream()
                .filter(this::isNotNumeric)
                .findAny()
                .ifPresent(e -> {
                    throw new IllegalArgumentException();
                });
    }

    private boolean isNotNumeric(String value) {
        return !value.matches("\\d+");
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
