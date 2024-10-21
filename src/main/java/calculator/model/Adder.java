package calculator.model;

import calculator.util.Validator;

public class Adder {

    private Validator validator;

    public Adder(Validator validator) {
        this.validator = validator;
    }

    public String addNums(String[] validatedInput) {
        int sum = 0;
        for (String s : validatedInput) {
            validator.validatePositiveNum(s);
            sum += Integer.parseInt(s);
        }
        return String.valueOf(sum);
    }
}
