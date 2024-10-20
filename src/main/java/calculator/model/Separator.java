package calculator.model;

public class Separator {
    private static final String ALLOWED_SEPARATOR = "[:|,]";
    private static final String ZERO = "";

    private final Validation validation;
    private String inputString;

    public Separator() {
        this.validation = new Validation();
    }

    private String establishSeparator(String inputString) {
        if (validation.isAllowedFrom(inputString)) {
            return ALLOWED_SEPARATOR;
        }

        if (validation.isCustomFrom(inputString)) {
            return Character.toString(inputString.charAt(2));
        }

        return ZERO;
    }

    public String getSeparator(String inputString) {
        validation.validate(inputString);
        return establishSeparator(inputString);
    }
}
