package calculator;

import calculator.constant.ErrorMessage;
import calculator.utils.NumberUtils;
import calculator.utils.StringUtils;

import java.util.List;

public class Validator {
    public void checkEachInputIsValid(List<String> strings) {
        for (String str : strings) {
            if (!StringUtils.isNumeric(str)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
            if (!NumberUtils.isPositiveNumber(StringUtils.convert(str))) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT.getMessage());
            }
        }
    }
}
