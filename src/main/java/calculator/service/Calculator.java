package calculator.service;

public class Calculator {
    public int calculate(String input) {
        long sum = 0;

        if (input.contains(",")) {
            String[] nums_str = input.split(",");

            for (String s : nums_str) {
                if (s.length() > 10 || (s.length() == 10 && s.compareTo("2147483647") > 0)) {
                    throw new IllegalArgumentException("입력 값이 int 범위를 초과합니다.");
                }

                try {
                    sum = sum + Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("구분자 사이 입력이 숫자가 아닙니다.");
                }

                if (sum > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException("입력 값의 합이 int 범위를 초과합니다.");
                }
            }
        }

        if (!input.contains(",")) {
            sum = Long.parseLong(input);
            if (sum > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("입력 값의 합이 int 범위를 초과합니다.");
            }
        }

        return (int) sum;
    }
}
