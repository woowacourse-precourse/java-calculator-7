package calculator.model;

import java.util.stream.IntStream;

public class CalculateSum {

    private final Convertor convertor;

    public CalculateSum() {
        this.convertor = new Convertor();
    }

    public int calculate(String expression) {
        int[] nums = convertor.getNums(expression);
        return IntStream.of(nums)
                .reduce(0, Math::addExact);
    }
}
