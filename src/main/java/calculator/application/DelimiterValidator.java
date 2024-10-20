package calculator.application;

public final class DelimiterValidator {

    public void validLastCharacter(final String target) {
        final var lastCharacter = target.length() - 1;

        if (!Character.isDigit(target.charAt(lastCharacter))) {
            throw new IllegalArgumentException();
        }
    }

    public void validCustomDelimiterSize(final String[] value) {
        if (value.length != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validCustomDelimiter(final String[] value) {
        if (DelimiterSpecification.INVALID_CUSTOM_DELIMITER_LIST.contains(Delimiter.from(value[0]))) {
            throw new IllegalArgumentException();
        }
    }
}