package calculator.dto;

import calculator.util.IntegerConverter;

import java.util.List;

public class SplittedResult {
    private final IntegerConverter integerConverter = new IntegerConverter();
    private final List<String> stringList;

    public SplittedResult(List<String> stringList) {
        this.stringList = stringList;
    }

    public int sum() {
        List<Integer> integerList = integerConverter.convertToIntegerList(stringList);

        int sum = 0;
        for (Integer num : integerList) {
            sum += num;
        }
        return sum;
    }

    public List<String> getIntegerList() {
        return stringList;
    }
}