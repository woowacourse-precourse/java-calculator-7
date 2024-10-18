package calculator.validate;

public class StringValidate {
    public static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
        if (!input.startsWith("//")) {
            throw new IllegalArgumentException("문자열은 '//'로 시작해야 합니다.");
        }
        if (!input.contains("\n")) {
            throw new IllegalArgumentException("문자열에 '\n'이 있어야 합니다.");
        }
        return input;
    }

    public static boolean validateFrontString(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("해당 문자열은 문자로만 이루어져야 합니다.");
            }
        }
        return true;
    }
}
