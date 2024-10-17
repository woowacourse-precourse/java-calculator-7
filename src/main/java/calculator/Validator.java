package calculator;

public class Validator {

    public static void validate(String value) {
        checkBeginAndEndOfValue(value);
    }

    //문자열의 시작과 끝 확인
    private static void checkBeginAndEndOfValue(String value) {
        //문자열의 시작 확인
        if (!value.startsWith("//") && !isNum(value.charAt(0))) {
            throw new IllegalArgumentException("문자열의 시작은 커스텀 구분자 선언 또는 양수여야 합니다");
        }

        //문자열의 끝 확인
        if (!value.endsWith("\n") && !isNum(value.charAt(value.length() - 1))) {
            throw new IllegalArgumentException("문자열의 끝은 커스텀 구분자 종료 선언 또는 양수여야 합니다.");
        }
    }


    //char값이 1 ~ 9 사이의 양수인지 확
    private static boolean isNum(char c) {
        return c >= '1' && c <= '9';
    }
}
