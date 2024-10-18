package calculator.util.validator;

import static calculator.constant.ErrorType.INVALID_INPUT_FORMAT;
import static calculator.constant.ErrorType.OUT_OF_RANGE;

import calculator.util.parser.StringParser;
import java.math.BigInteger;
import java.util.Arrays;

public class InputStringValidator implements StringValidator {

    private final StringParser stringParser;

    public InputStringValidator(final StringParser stringParser) {
        this.stringParser = stringParser;
    }

    @Override
    public void validateFormat(final String str) {
        if (isInvalidFormat(str)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    @Override
    public void validateRange(final String str, final BigInteger min, final BigInteger max) {
        if (isOutOfRange(str, min, max)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(final String str, final BigInteger min, final BigInteger max) {
        final String[] tokens = stringParser.extractTokens(str);
        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .map(BigInteger::new)
                .anyMatch(num -> num.compareTo(min) < 0 || num.compareTo(max) > 0);
    }

    private boolean isInvalidFormat(final String str) {
        final String[] tokens = stringParser.extractTokens(str);
        return Arrays.stream(tokens)
                .anyMatch(token -> !token.matches("\\d*"));
    }
}

