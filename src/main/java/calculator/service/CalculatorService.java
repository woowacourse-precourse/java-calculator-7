package calculator.service;

public class CalculatorService {
    private static int sumNumbers(int[] input) {
        int sum = 0;
        for (int number : input) {
            sum += number;
        }
        return sum;
    }
}