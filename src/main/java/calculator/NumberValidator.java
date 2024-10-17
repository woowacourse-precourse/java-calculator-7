package calculator;

import java.util.List;

public class NumberValidator {
    public void validate(List<String> stringInput) {
        for (String s : stringInput) {
            validateNumberFormat(s);
            validatePositiveNumber(s);
        }
    }

    // 정수인지 확인
    private void validateNumberFormat(String s){
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 형식입니다: "+s);
        }
    }

    // 양수인지 확인
    private void validatePositiveNumber(String s){
        int value = Integer.parseInt(s);
        if (value < 0) {
            throw new IllegalArgumentException("양수만 허용됩니다: "+s);
        }
    }
}
