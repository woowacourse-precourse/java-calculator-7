package calculator.validation;

import calculator.utils.Utils;

public class Validation {
    public static void validateNumberFormat(String number){
        if(!Utils.isNumeric(number)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다");
        }
    }
}
