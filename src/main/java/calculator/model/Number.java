package calculator.model;

import calculator.util.ErrorCode;

public class Number {
    private Long value;

    public Number(Long value) {
        validate(value);
        this.value = value;
    }

    private void validate(Long value){
        if (value < 0) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_ERROR.getMessage());
        }
    }
}
