package calculator.infrastructure;

import calculator.exception.InvalidSplitStrException;
import java.util.ArrayList;
import java.util.List;

public class SplitStrListValidator {
    public List<Long> makeNumberList(List<String> splitStrBySeparators) {
        List<Long> numberList = new ArrayList<>();
        // 리스트의 각 요소는 숫자여야 하며, Long 타입 범위를 넘어서서는 안된다.
        for (String splitStr : splitStrBySeparators) {
            try {
                numberList.add(Long.parseLong(splitStr));
            } catch
            (NumberFormatException e) {
                throw new InvalidSplitStrException(splitStr);
            }
        }
        return numberList;
    }
}
