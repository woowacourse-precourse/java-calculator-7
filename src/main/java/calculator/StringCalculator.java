package calculator;

public class StringCalculator {
    public String[] splitInput(String input) {
        return input.split("[,:]");
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInput(input);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}