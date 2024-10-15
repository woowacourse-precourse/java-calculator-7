package calculator.service;

import java.util.List;

public class Adder {

    public int addAllNumbers(List<Integer> integers) {
        int result = 0;

        for (Integer integer : integers) {
            result += integer;
        }

        return result;
    }
}
