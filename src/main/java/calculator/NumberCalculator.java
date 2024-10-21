package calculator;

public class NumberCalculator {

   public int calculateSum(String[] splitNumbers) {
        int sum = 0;
        for (String splitNum : splitNumbers) {
            int number = NumberValidator.validate(splitNum);
            sum += number;
        }
        return sum;
    }
}