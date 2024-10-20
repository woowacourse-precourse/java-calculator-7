package calculator.infrastructure;

import calculator.exception.InvalidSplitStrException;
import calculator.exception.NonNumericCharacterException;
import java.util.ArrayList;
import java.util.List;

public class SplitStrListValidator {
    public List<Long> makeNumberList(List<String> splitStrBySeparators) {
        List<Long> numberList = new ArrayList<>();
        // 리스트의 각 요소는 숫자여야 하며, Long 타입 범위를 넘어서서는 안된다.
        for (String splitStr : splitStrBySeparators) {
            try {
                validateArithmeticNumber(splitStr);
                numberList.add(Long.parseLong(splitStr));
            } catch (NumberFormatException | NonNumericCharacterException e) {
                throw new InvalidSplitStrException(splitStr, e);
            }
        }
        return numberList;
    }

    private void validateArithmeticNumber(String splitStr) {
        for (char s : splitStr.toCharArray()) {
            if (!String.valueOf(s).matches("[0-9]")) {
                throw new NonNumericCharacterException(s);
            }
        }
    }
}
