package calculator.service;

public class Calculator {

    public int sumNumber(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
