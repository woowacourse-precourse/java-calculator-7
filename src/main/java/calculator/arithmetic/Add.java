package calculator.arithmetic;

import java.util.List;

public class Add {
    public Integer addNum(List<Integer> numbers){
        Integer sum = 0;
        for(Integer num: numbers) sum+=num;

        return sum;
    }
}
