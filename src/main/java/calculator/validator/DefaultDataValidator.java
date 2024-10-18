package calculator.validator;

public class DefaultDataValidator {

    private static final String ILLEGAL_ELEMENT_MESSAGE = "데이터가 구분자 또는 숫자로 이루어지지 않았습니다.";

    public static void checkValidContents(String content) {
        char[] contentArr = content.toCharArray();
        for(int i = 0; i < content.length(); i++) {
            char c = contentArr[i];
            if (!(isNumber(c) || isSeparator(c))) {
                throw new IllegalArgumentException(ILLEGAL_ELEMENT_MESSAGE);
            }
        }
    }

    private static boolean isSeparator(char c) {
        char[] separators = new char[]{',', ':'};

        for(int i = 0 ; i < separators.length; i++) {
            if (c == separators[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}
