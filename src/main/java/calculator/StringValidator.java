package calculator;

// 유효성 검사
public class StringValidator {
    public void validate(String[] tokens) {
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                // 음수인 경우
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
            } catch (NumberFormatException e) {
                // 숫자가 아닌 경우
                throw new IllegalArgumentException("유효하지 않은 입력: " + token);
            }
        }
    }
}
