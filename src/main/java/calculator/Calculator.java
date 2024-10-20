package calculator;

public class Calculator {
    public int calculate(String input) {

        int sum = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";

        if(input.startsWith("//")){

            delimiter = String.valueOf(input.charAt(2));
            input = input.substring(5);
        }
        String[] tokens = input.split(delimiter); //쉼표나 콜론을 구분자로 분리

        int number;

        for (String token : tokens) {

            try {
                number = Integer.parseInt(token.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }

        return sum;
    }
}
