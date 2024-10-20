package calculator.domain;

import java.util.List;

public class ResultMaker {

    public static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
