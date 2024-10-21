package calculator;

public class Validator {
    // 기본 구분자인 쉼표, 콜론을 기준으로 문자열 검증
    public void validateDefaultDelimiters(String input) {
        // 빈 문자열인 경우 바로 통과
        if (input.isEmpty()) {
            return;
        }

        // 쉼표(,)와 콜론(:)만 있는지 확인 (숫자, 쉼표, 콜론만 허용)
        if (input.matches("[0-9,:]+")) {
            System.out.println("입력값이 올바른 형식입니다.");
        }
    }
}
