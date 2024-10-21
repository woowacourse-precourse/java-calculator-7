package calculator.model;

import java.util.List;

public class Adder {
    public Long addAll(List<Number> numbers){
        Long ret = 0L;

        for (Number number : numbers) {
            ret += number.getValue();
        }

        return ret;
    }
}
