package calculator;

public class Calculator {

    // 각 토큰을 합산하고 예외 처리
    public int calculateSum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수 값이 포함되어 있습니다. : " + token);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }

        return sum; // 총합 반환
    }
}
