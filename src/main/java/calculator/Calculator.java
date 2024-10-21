package calculator;

public class Calculator {

    public static int sumNumbers(String[] nums) {
        int sum = 0;

        for (String num : nums) {
            if (!num.isBlank()) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }
}
