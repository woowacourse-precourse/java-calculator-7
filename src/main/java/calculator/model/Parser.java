package calculator.model;

import java.util.List;

public class Parser {

    public List<Integer> parseNum(List<String> stringList) {
        return stringList.stream().map(s -> {
            Integer positiveNum = parseInt(s);
            checkPositive(positiveNum);
            return positiveNum;
        }).toList();
    }

    private Integer parseInt(String s) {
        int number;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private void checkPositive(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
