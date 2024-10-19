package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitString(input);
        int sum = sumNumbers(numbers);

        return sum;
    }

    private String[] splitString(String input) {
        return input.split(",|:");
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
