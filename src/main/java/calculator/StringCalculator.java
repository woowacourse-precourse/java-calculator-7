package calculator;

public class StringCalculator {
    public int calculate(String[] numbers) {

        int sum = 0;

        for (String stringNum : numbers) {
            if (stringNum.isEmpty()) {
                sum += 0;
                continue;
            }
            sum += Integer.parseInt(stringNum);
        }
        return sum;
    }
}
