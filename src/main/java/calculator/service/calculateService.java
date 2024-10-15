package calculator.service;

import java.util.List;
import java.util.stream.Collectors;

public class calculateService {
    //계산
    public int calculate(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue).sum();
    }
}
