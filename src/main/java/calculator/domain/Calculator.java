package calculator.domain;

public class Calculator {

    public int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|:");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
