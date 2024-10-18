package calculator;

import java.util.List;

public class MathUtils {
    public int add(List<Integer>numbers){
        int result = 0;
        for(int number : numbers){
            result += number;
        }
        return result;
    }

}
