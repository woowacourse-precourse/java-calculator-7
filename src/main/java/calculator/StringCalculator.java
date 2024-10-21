package calculator;

public class StringCalculator {
    public static int addition(String input) {
        String seperator = ",|:";

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] numbers = input.split(seperator);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
