package calculator;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int[] numbers = DataCleaner.cleanData(input);
        return sum(numbers);
    }

    private int sum(int[] numbers) {
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        return result;
    }
}
