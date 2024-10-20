package calculator.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers = new ArrayList<>();

    public void addNumbers(List<Integer> numberList) {
        numbers.addAll(numberList);
    }

    public Integer sum() {
        Integer result = 0;
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            result += number;
            iterator.remove();
        }
        return result;
    }
}
