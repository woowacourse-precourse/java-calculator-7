package calculator;

public class InputValidator {
    public static void validate(String input) {
        // 빈 문자열을 허용 -> 이후 0으로 계산
        if (input == null || input.isEmpty()) {
            return;
        }

        // 기본 구분자인 쉼표(,), 콜론(:)으로 구분
        String[] parts = input.split("[,|:]"); // 정규 표현식
        for (String part : parts) {
            if (!part.isEmpty()) {
                try {
                    int num = Integer.parseInt(part); // 숫자가 아닌 경우 예외 발생
                    // 음수 처리
                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력 값입니다: " + part);
                }
            }
        }
    }
}
