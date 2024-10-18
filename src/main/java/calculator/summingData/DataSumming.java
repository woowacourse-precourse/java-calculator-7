package calculator.summingData;

import java.util.List;

public class DataSumming {
    private DataSumming(){}

    public static Integer sumData(List<Integer> numbers){
        int sum = 0;
        for(Integer number : numbers){
            sum += number;
        }

        return sum;
    }
}
