package calculator.domain;

import java.util.List;

public class Result {

    private final List<Integer> numbers;
    public Result(List<Integer> numbers){
        this.numbers = numbers;
    }

    public int getTotal(){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
