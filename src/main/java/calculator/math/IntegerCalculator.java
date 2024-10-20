package calculator.math;

public class IntegerCalculator implements Calculator<Integer> {

    @Override
    public Integer sum(Iterable<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}
