package calculator;

public class SumCalculator {
    private static SumCalculator instance;

    private SumCalculator() {}

    public static SumCalculator getInstance() {
        if (instance == null) {
            instance = new SumCalculator();
        }
        return instance;
    }

    public int calculateSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
