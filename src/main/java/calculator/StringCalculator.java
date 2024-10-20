package calculator;

public class StringCalculator {
    public int sumTokens(String[] tokens) {
        if (tokens.length == 1 && tokens[0].isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        int sum = 0;
        for (String token : tokens) {
            sum += parseNumber(token); // 숫자로 변환 후 합산
        }
        return sum;
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token); // 숫자로 변환
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력 값입니다."); // 음수일 경우 예외 발생
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다."); // 숫자로 변환 불가 시 예외 발생
        }
    }
}
