package calculator;

public class StringValidator {
    // 입력값 null 확인
    public static void nullValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
    }
    // 입력값 empty 확인
    public static void emptyValidate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("구분자 외 문자열이 없습니다.");
        }
    }
    // 입력값 숫자 확인
    public static void numValidate(String input){
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return;
            }
        }
        throw new IllegalArgumentException("입력 문자열에 숫자가 없습니다.");
    }
}