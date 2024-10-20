package calculator;

public class Calc {
    public int calculate(String input, String delimiterPattern) {
        int sum = 0;

        if (input == null || input.trim().isEmpty()) {
            return sum;
        }

        String[] numbers = input.split(delimiterPattern);
        for (String number : numbers) {
            number = number.trim();
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}