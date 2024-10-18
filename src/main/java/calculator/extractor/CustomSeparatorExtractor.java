package calculator.extractor;

public final class CustomSeparatorExtractor {
    private static final String CUSTOM_SEPARATOR_FORMAT = "^//.\\\\n.*";

    public boolean hasCustomSeparator(String str) {
        return str.matches(CUSTOM_SEPARATOR_FORMAT);
    }
}