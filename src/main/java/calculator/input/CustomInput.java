package calculator.input;

public class CustomInput extends Input {

    private static final String ESCAPES = ".^$*+?()[]{}|\\";
    private static final String ESCAPE_SEPARATOR_PREFIX = "\\";

    private final String separator;

    private CustomInput(String numStr, String separator) {
        super(numStr.split(separator));
        this.separator = separator;
    }

    protected static CustomInput from(String numStr, String separator) {
        return new CustomInput(numStr, getEscapeSafeSeparator(separator));
    }

    @Override
    protected boolean matchesSeparator(String separator) {
        return this.separator.equals(separator);
    }

    private static String getEscapeSafeSeparator(String separator) {
        if (isEscape(separator)) {
            return createEscapeSeparator(separator);
        }
        return separator;
    }

    private static boolean isEscape(String separator) {
        return ESCAPES.contains(separator);
    }

    private static String createEscapeSeparator(String separator) {
        return ESCAPE_SEPARATOR_PREFIX + separator;
    }
}
