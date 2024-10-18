package calculator.domain.number;

import calculator.global.util.Validator;

public class Number {
    private final String number;

    public Number(String number) {
        this.number = number;
        Validator.ValidateNumberFormat(number);
    }

    public Integer toInteger() {
        return Integer.parseInt(number);
    }
}
