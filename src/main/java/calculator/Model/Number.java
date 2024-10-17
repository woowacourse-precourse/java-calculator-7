package calculator.Model;

import calculator.Constants.ErrorMessages;
import calculator.Utils.NumberUtils;

public class Number {
    private final Double number;

    public Number(String number) {
        this.number = parseAndValidate(number);
    }

    public Double getNumber() {
        return number;
    }

    private Double parseAndValidate(String number) {
        if (isNull(number)) {
            return 0.0;
        }
        NumberUtils.isDouble(number);
        Double parsedNumber = Double.parseDouble(number);
        isPositive(parsedNumber);
        return parsedNumber;
    }

    private void isPositive(Double number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getErrorMessage());
        }
    }

    private boolean isNull(String number) {
        return number.isEmpty() || number.isBlank();
    }
}
