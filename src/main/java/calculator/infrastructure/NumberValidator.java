package calculator.infrastructure;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class NumberValidator {
    public List<Number> makeNumberList(String[] splitStrBySeparators) {
        List<Number> numberList = new ArrayList<>();
        for (String splitStr : splitStrBySeparators) {
            numberList.add(new Number(splitStr));
        }
        return numberList;
    }
}
