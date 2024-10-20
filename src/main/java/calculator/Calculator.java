package calculator;

public class Calculator {
    public static int inputCalculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열인 경우 0 반환
        }

        int sum = 0;
        String[] nums = Division.StringDivision(input);

        for (String num : nums) {
            int number = Integer.parseInt(num.trim());

            if (number < 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }

            sum += number;
        }

        return sum;
    }
}
