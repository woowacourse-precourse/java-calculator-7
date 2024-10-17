package calculator;

public class Adder {
    public int calculateSum(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
