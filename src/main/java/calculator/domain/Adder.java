package calculator.domain;

import java.util.List;

public class Adder {
    public static int add(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
