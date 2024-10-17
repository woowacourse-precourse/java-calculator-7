package calculator.models;

public class NumberModel {
    public static int getSum(String input, String regex) {
        String[] numbers = input.split(regex);
        int sum = 0;

        for (String number : numbers) {
            int value = number.isEmpty() ? 0 : Integer.parseInt(number);
            sum += value;
        }

        return sum;
    }
}
