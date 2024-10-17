package validator;

public class InputValidator {

    public static void checkInput(final String input) {
        hasNumber(input);
    }

    private static void hasNumber(final String input) {
        for(char value: input.toCharArray()) {
            if(Character.isDigit(value)){
                return;
            }
        }

        throw new IllegalArgumentException("구분자와 양수로 구성된 문자를 입력해야 합니다.");
    }
}
