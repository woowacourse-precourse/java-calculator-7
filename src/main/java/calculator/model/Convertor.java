package calculator.model;

public class Convertor {

    private final Validator validator;

    public Convertor() {
        this.validator = new Validator();
    }

    public int[] getNums(String expression) {
        return validator.validateAndParse(expression);
    }
}
