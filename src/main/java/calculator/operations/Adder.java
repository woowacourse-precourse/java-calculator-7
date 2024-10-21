package calculator.operations;

public class Adder implements Calculator {
    @Override
    public Integer calculate(Integer[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
