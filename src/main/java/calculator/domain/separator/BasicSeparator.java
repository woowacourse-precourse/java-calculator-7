package calculator.domain.separator;

import calculator.domain.number.Number;
import java.util.Arrays;
import java.util.List;

public class BasicSeparator implements Separator {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    @Override
    public List<Number> separate(String value) {
        if (hasSeparatorIn(value)) {
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

    private boolean hasSeparatorIn(String value) {
        return value.contains(COMMA) || value.contains(COLON);
    }

    private List<Integer> convert(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private List<String> divideBySeparator(String value) {
        return Arrays.stream(value.split(COMMA + "|" + COLON))
                .toList();
    }

    private List<String> validate(String value) {
        List<String> values = validateOfSeparator(value);
        validateNumber(values);

        return values;
    }

    private List<String> validateOfSeparator(String value) {
        validateEdgeSeparator(value);
        validateContinuousSeparator(value);
        return divideBySeparator(value);
    }

    private void validateNumber(List<String> value) {
        value.stream()
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
        if (hasEdgeSeparator(value, COMMA) || hasEdgeSeparator(value, COLON)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasEdgeSeparator(String value, String separator) {
        return value.startsWith(separator) || value.endsWith(separator);
    }

    private void validateContinuousSeparator(String value) {
        if (isContinuousSeparator(value, COMMA) || isContinuousSeparator(value, COLON)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContinuousSeparator(String value, String separator) {
        return value.contains(separator.repeat(2));
    }
}
