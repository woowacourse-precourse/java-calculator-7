package calculator;

public class Validator {

    private static final String target = "\\\\n";
    private static final String end = "e";

    public static void checkValidCustomFormat(String inputData) {
        String replaceData = inputData.replaceAll(target, end);
        int count = getEndCount(replaceData);
        if (count != 1) {
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

    private static int getEndCount(String replaceData) {
        int count = 0;
        char[] arr = replaceData.toCharArray();
        char target = end.charAt(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }
}
