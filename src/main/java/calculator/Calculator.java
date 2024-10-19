package calculator;

public class Calculator {
    public int calculate(String input) {

        int sum = 0;

        if (input == null || input.isEmpty()) {
            return sum;
        }

        if (input.startsWith("/")){
            sum = customCalculate(input);
            return sum;
        }

        String[] tokens = input.split("[,:]"); //쉼표나 콜론을 구분자로 분리

        for (String token : tokens) {

            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }

        return sum;
    }

    private int customCalculate(String input) {

        String delimiter = String.valueOf(input.charAt(2));
        String realInput = input.substring(5);

        String[] tokens = realInput.split(delimiter);

        int sum = 0;
        int number = 0;

        for (String token : tokens) {

            number = Integer.parseInt(token.trim());
            if(number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }
        return sum;
    }
}
