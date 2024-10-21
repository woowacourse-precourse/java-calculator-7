package calculator.valid;

import java.util.List;

public class Validation {

    //TODO 2 : 숫자 유효성 검증 기능
    public static void validation(List<Integer> numberList) {
        for (Integer number : numberList) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

}
