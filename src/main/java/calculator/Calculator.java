package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표(,) 또는 콜론(:)을 구분자로 하여 문자열을 분리
        String[] numbers = input.split("[,:]");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
