package calculator;

public class Calculator {
    private final Validator validator;
    private final Separator separator;
    private final Plus plus;

    public Calculator() {
        validator = new Validator();
        separator = new Separator();
        plus = new Plus();
    }

    public int calc(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        validator.validate(input);

        return plus.plus(separator.separate(input));

    }
}
