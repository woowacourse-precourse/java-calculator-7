package calculator.model;

import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer sum(List<Integer> integerList) {
        return integerList.stream().reduce(0, Integer::sum);
    }
}
