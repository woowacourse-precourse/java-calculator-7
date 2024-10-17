package calculator;

public class Validator {

    public static void checkValidCustomFormat(String inputData) {
        if (!inputData.contains("\\n")) {
            throw new IllegalArgumentException();
        }
        String[] splitData = inputData.split("\\\\n");
        int count = splitData.length;
        if (!(count == 1 || count == 2)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidContents(char[] separators, char[] contents) {
        int index = 0;
        while (index < contents.length) {
            char c = contents[index];
            if (!(isSeparators(c, separators) || isNumber(c))) {
                throw new IllegalArgumentException();
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
