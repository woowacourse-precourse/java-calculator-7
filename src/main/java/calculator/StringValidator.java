package calculator;

public class StringValidator {

    public static void nullValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
    }

    public static void emptyValidate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어있습니다.");
        }
    }

    public static void numValidate(String input){
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return;
            }
        }
        throw new IllegalArgumentException("입력 문자열에 숫자가 없습니다.");
    }
}