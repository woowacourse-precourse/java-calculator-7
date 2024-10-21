package calculator;

import java.util.List;

public class Calculate {
    public static Long getTotalPlus(List<Integer> numberList){
        long result = 0L;
        for(int i : numberList){
            result += i;
        }
        return result;
    }
}
