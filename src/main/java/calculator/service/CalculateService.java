package calculator.service;

import java.util.List;

public class CalculateService {
    public static Integer calc(){
        int result = 0;
        List<Integer> numbers = NumberService.getNumbers();
        for(Integer number : numbers){
            result += number;
        }
        return result;
    }
}
