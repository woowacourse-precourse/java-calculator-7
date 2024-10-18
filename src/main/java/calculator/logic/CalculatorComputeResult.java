package calculator.logic;

import java.util.List;

public class CalculatorComputeResult {
    public Integer computeResult(List<Integer> integerList) {
        Integer result = 0;
        for (Integer num : integerList) {
            result += num;
        }
        return result;
    }

}
