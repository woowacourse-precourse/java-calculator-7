package calculator;

public class Calculator {
    private final Validator validator;
    private final Separator separator;
    private final Plus plus;

    public Calculator() {
        this.validator = new Validator();
        this.separator = new Separator();
        this.plus = new Plus();
    }

    public int calc(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        validator.validate(input);
        String regex = separator.getSeparator(input);
        return plus.plus(separator.separate(input, regex));
    }
}
