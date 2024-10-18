package calculator.domain;

import java.util.List;

public class Adder {

    public Long add(List<Long> numbers){
        long sum = 0;
        for (Long number : numbers){
            sum += number;
        }
        return sum;
    }

}
