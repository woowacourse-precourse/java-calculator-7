package calculator;

public class StringAddCalculator {

    public static int calculator(String input) {
        String delimiter = "[,:]";

        String[] numbers = input.split(delimiter);

        return sum(numbers);
    }

    static int sum(String[] numbers) {
        int sum = 0;

        for (String number: numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
