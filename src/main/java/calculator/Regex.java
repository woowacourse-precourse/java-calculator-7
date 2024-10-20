package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Regex {

    private String expression;
    private List<Integer> numbers = new ArrayList<>();

    public void setExpression(String expression){
        this.expression = expression;
    }

    public void setNumbers(String delimiter){
        numbers = parseNumbersFromExpression(delimiter);
    }

    private List<Integer> parseNumbersFromExpression(String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .map(this::parseExpression)
                .collect(Collectors.toList());
    }

    private int parseExpression(String value) {
        if (value.isEmpty()) {
            return 0;
        }
        try {
            int number = Integer.parseInt(value);
            validateIsPositive(number);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void validateIsPositive(int value) {
        if(value <= 0){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public long sumNumbers(){
        return numbers.stream().mapToLong(Integer::intValue).sum();
    }
}
