package calculator;

public class Validator {

    private static final String INVALID_PAIR_ERROR_MESSAGE = "커스텀 구분자의 형식이 올바르지 않습니다.";
    private static final String INVALID_CONTENTS_MESSAGE = "피 연산 데이터에 구분자와 숫자가 아닌 문자가 포함되어 있습니다.";

    public static void checkValidCustomFormat(String inputData) {
        char[] inputDataArray = inputData.toCharArray();
        int count = 0;
        int index = 0;

        while (index < inputDataArray.length - 1) {
            char c1 = inputDataArray[index];
            char c2 = inputDataArray[index + 1];
            if (c1 == '\\' && c2 == 'n') {
                count++;
            }
            index++;
        }

        if (count != 1) {
            throw new IllegalArgumentException(INVALID_PAIR_ERROR_MESSAGE);
        }
    }

    public static void checkValidContents(char[] separators, char[] contents) {
        int index = 0;
        while (index < contents.length) {
            char c = contents[index];
            if (!(isSeparators(c, separators) || isNumber(c))) {
                throw new IllegalArgumentException(INVALID_CONTENTS_MESSAGE);
            }
            index++;
        }
    }

    private static boolean isSeparators(char c, char[] separators) {
        for (int i = 0; i < separators.length; i++) {
            if (c == separators[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
}
