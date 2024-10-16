package calculator.model;

public class StringCalculator {


    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }

}
