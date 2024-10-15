package calculator.model;

public class CalculatorModel {
    public int addNumber(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }

        return sum;
    }
}
