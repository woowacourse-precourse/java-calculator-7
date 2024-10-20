package calculator.service;

public class CalculatorService {
    public int sumSplitNumbers(String[] splitNumbers) {
        int sum = 0;
        for (String splitNumber : splitNumbers) {
            sum += Integer.parseInt(splitNumber);
        }
        return sum;
    }
}
