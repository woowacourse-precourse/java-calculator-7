package calculator.service;

public class Calculator {
    public int calculate(String input) {
        int sum = 0;

        if (input.contains(",")) {
            String[] nums_str = input.split(",");

            for (String s : nums_str) {
                try {
                    sum = sum + Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("구분자 사이 입력이 숫자가 아닙니다.");
                }
            }
        }

        if (!input.contains(",")) {
            sum = Integer.parseInt(input);
        }

        return sum;
    }
}
