package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static List<Integer> numbers = new ArrayList<>();

    public static void setNumbers(List<Integer> nums){
        List<Integer> copy = new ArrayList<>(nums);  // 복사본 생성
        for (Integer number : copy) {
            numbers.add(number);
        }
    }

    public static List<Integer> getNumbers(){
        return numbers;
    }
}
