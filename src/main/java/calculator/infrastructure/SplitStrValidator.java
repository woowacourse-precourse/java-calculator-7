package calculator.infrastructure;

import calculator.common.exception.InvalidateArithmeticNumberException;
import calculator.common.exception.OutOfLongRangeException;
import java.util.ArrayList;
import java.util.List;

public class SplitStrValidator {
    public List<Long> makeNumberList(String[] splitStrBySeparators) {
        List<Long> numberList = new ArrayList<>();
        // 리스트의 각 요소는 숫자여야 하며, Long 타입 범위를 넘어서서는 안된다.
        for (String splitStr : splitStrBySeparators) {
            validateArithmeticNumber(splitStr);
            try {
                numberList.add(Long.parseLong(splitStr));
            } catch (NumberFormatException e) {
                throw new OutOfLongRangeException(splitStr, e);
            }
        }
        return numberList;
    }

    private void validateArithmeticNumber(String splitStr) {
        for (char s : splitStr.toCharArray()) {
            if (!String.valueOf(s).matches("[0-9]")) {
                throw new InvalidateArithmeticNumberException(splitStr);
            }
        }
    }
}
