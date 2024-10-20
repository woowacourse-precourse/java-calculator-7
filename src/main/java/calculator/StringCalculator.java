package calculator;

public class StringCalculator {
    public int add(String input) {
        String[] numbers = split(input);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private String[] split(String input) {
        String delimiter = "[,:]";

        return input.split(delimiter);
    }
}
