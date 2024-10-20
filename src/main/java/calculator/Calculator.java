package calculator;

import java.util.List;

public class Calculator {


    static String sumNumbers(List<Integer> numbers){
        int result = 0;
        for (Integer number : numbers)
            result+=number;

        return Integer.toString(result);
    }
}
