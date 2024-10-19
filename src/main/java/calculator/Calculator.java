package calculator;

public class Calculator {
    public int calculate(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = input.split("[,:]"); //쉼표나 콜론을 구분자로 분리
        int sum = 0;

        for (String token : tokens) {

            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }

        return sum;
    }
}
