package calculator;

public class AddCalculator {
    private int[] numbers;
    private int sum;

    public AddCalculator(int[] numbers) {
        this.numbers = numbers;
    }

    public int add() {
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}
