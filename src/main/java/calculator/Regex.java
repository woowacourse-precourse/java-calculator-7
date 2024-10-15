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
        numbers = getList(delimiter);
        validateIsPositive();
    }

    private List<Integer> getList(String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .map(value -> {
                    if (value.isEmpty()) {
                        return 0;
                    }
                    try {
                        return Integer.parseInt(value);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("잘못된 입력값입니다.");
                    }
                })
                .collect(Collectors.toList());
    }

    private void validateIsPositive() {
        for(int number : numbers) {
            if(number < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    public long sumNumbers(){
        return numbers.stream().mapToLong(Integer::intValue).sum();
    }
}
