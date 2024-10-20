package calculator.model;

import java.util.List;

public class Validation {
    public boolean isValidInput(List<String> list) {
        boolean isInteger = list.stream().allMatch(this::isPositiveInteger);
        return isInteger;
    }

    public boolean isPositiveInteger(String str) {
        try {
            if (Integer.parseInt(str) < 0) {
                throw new IllegalArgumentException("음의 정수가 입력되었습니다: " + str);
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 문자가 포함되어 있습니다: " + str);
        }
    }


}
