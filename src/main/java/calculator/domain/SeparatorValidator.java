package calculator.domain;

public class SeparatorValidator {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";

    public SeparatorValidator() {
    }

    public static String validateSeparator(String inputData) {
    }

    private boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }
}
