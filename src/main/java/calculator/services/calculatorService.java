package calculator.services;

public class calculatorService {

    private long calculateSum(long[] numbers) {
        long sumResult = 0;
        for (long number : numbers) {
            sumResult += number;
        }
        return sumResult;
    }
}