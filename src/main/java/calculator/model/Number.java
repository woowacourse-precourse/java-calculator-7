package calculator.model;

import calculator.util.ErrorCode;

public class Number {
    private Long value;

    public Number(String srtValue) {
        validate(srtValue);
        this.value = Long.parseLong(srtValue);
    }

    private void validate(String strValue){
        Long tmpValue;

        try {
            tmpValue = Long.parseLong(strValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.NUMBER_FORMAT_ERROR.getMessage());
        }

        if (tmpValue < 0) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public Long getValue() {
        return this.value;
    }
}
