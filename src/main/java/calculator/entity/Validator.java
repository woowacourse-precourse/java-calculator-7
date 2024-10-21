package calculator.entity;

import static calculator.config.CalcConfig.INPUT_ONLY_NUM;
import static calculator.config.CalcConfig.NOT_ALLOW_NEGATIVE_NUM;

public class Validator {
    public void validateInputNum(String[] splitNum) {
        for (String num : splitNum)
            validateSingleNum(num.trim());
    }

    public void validateSingleNum(String num) {
        if (!isValidNum(num))
            throw new IllegalArgumentException(INPUT_ONLY_NUM);
        if (Integer.parseInt(num) < 0)
            throw new IllegalArgumentException(NOT_ALLOW_NEGATIVE_NUM);
    }

    private boolean isValidNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}