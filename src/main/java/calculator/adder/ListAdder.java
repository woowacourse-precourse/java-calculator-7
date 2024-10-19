package calculator.adder;

import java.util.List;

public class ListAdder {
    private ListAdder(){}

    public static Integer sumData(List<Integer> numbers){
        int sum = 0;
        for(Integer number : numbers){
            sum += number;
        }

        return sum;
    }
}
