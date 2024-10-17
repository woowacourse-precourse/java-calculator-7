package calculator;

public class Validator {

    public static void validate(String value) {
        checkBeginAndEndOfValue(value);
        checkCustomSeparatorFormat(value);
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


    //문자열에서 커스텀 구분자 형식 유효성 검사하기
    private static void checkCustomSeparatorFormat(String value) {
        if (!value.contains("//")) {
            return;
        }

        int start = value.indexOf("//");
        int end = value.indexOf("\n");

        // 커스텀 구분자 선언이 //후에 \n인 형태인지,
        if (start > end) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        if (end + 2 < value.length()) {
            checkCustomSeparatorFormat(value.substring(end + 2));
        }

    }


    //char값이 1 ~ 9 사이의 양수인지 확
    private static boolean isNum(char c) {
        return c >= '1' && c <= '9';
    }
}
