package calculator;

public class StringCalculator {
    public int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token); // 숫자로 변환 후 합산
        }
        return sum;
    }
}
