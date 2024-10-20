package calculator;

public class Calculator {

    public int calculate(String input) {
        String delimiter = ",|:";
        String numbers = input;

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;
    }
}
