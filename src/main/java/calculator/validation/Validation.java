package calculator.validation;

import calculator.utils.Utils;

public class Validation {
    public static void validateNumberFormat(String number){
        if(!Utils.isNumeric(number)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다");
        }
    }

    public static void validateIntRange(String number){
        if(number.length() > 10) {
            throw new IllegalArgumentException("계산할 수 있는 범위를 벗어났습니다");
        }
    }

    public static void validateNegativeNumber(String number){
        if(Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다");
        }
    }

    public static void validateBackSlashDelimiter(String delimiter){
        if(delimiter.contains("\\")){
            throw new IllegalArgumentException("구분자에 '\\'를 포함할 수 없습니다");
        }
    }
}
