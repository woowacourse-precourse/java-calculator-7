package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static List<Integer> numbers;

    public static void setNumbers(List<Integer> originalNumbers){
        numbers = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(originalNumbers);
        for (Integer number : copy) {
            numbers.add(number);
        }
    }

    public static List<Integer> getNumbers(){
        return numbers;
    }
}
