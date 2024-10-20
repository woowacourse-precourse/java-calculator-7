package calculator.validators;

public class InvalidOperandFormatException {
    // 빈 값 및 정수 체크를 위한 함수
    private static void validateToken(String token) {
        checkEmpty(token);
        checkInteger(token);
    }
    private static void checkEmpty(String str){
        if (str.isEmpty()) {
            throw new IllegalArgumentException("빈 값이 있습니다.");  // 빈 값 예외 처리
        }
    }

    private static int checkInteger(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 값입니다");
        }
    }
}
