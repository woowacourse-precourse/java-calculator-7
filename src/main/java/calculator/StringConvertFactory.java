package calculator;

public class StringConvertFactory {

    private final StringValidator stringValidator;

    public StringConvertFactory() {
        this.stringValidator = new StringValidator();
    }

    public String[] parseString(String input) {

        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (input.matches("\\d+")) {
            return new String[]{input};
        }
        stringValidator.validate(input);

        return new String[0];
    }
}
