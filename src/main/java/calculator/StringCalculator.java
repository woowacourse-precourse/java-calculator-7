package calculator;

public class StringCalculator {
    public int calculate(String[] numbers) {

        int sum = 0;

        for (String stringNum : numbers) {
            if (stringNum.isEmpty()) {
                continue;
            }
            sum += Integer.parseInt(stringNum);
        }
        return sum;
    }
}
