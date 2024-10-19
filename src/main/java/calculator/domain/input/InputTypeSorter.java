package calculator.domain.input;

public class InputTypeSorter {

    private static final CharSequence COMMA = ",";
    private static final CharSequence COLON = ":";
    private static final String DOUBLE_SLASH = "//";
    private static final String ESCAPE = "\\n";

    public static Input sort(String text) {
        if (isEmpty(text)) {
            return EmptyInput.from(text);
        }
        if (containsBasicDelimiter(text)) {
            return BasicInput.from(text);
        }
        if (containsCustomDelimiter(text)) {
            return CustomInput.from(text);
        }
        return OtherInput.from(text);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean containsBasicDelimiter(String text) {
        return text.contains(COMMA) || text.contains(COLON);
    }

    private static boolean containsCustomDelimiter(String text) {
        return text.contains(DOUBLE_SLASH) && text.contains(ESCAPE);
    }
}
