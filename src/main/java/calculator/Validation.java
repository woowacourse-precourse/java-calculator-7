package calculator;

public class Validation {

    // 올바른 문자열인지 아닌지 확인
    //
    public static boolean checkCustomSeparator(String input) {
        if (isCorrectCustomSeparatorForm(input)) {
            return true;
        }
        return false;
    }

    public static boolean isCorrectCustomSeparatorForm(String input) {
        input = Parser.getSeparatorString(input);
        return isCorrectPair(input);
    }

    private static boolean isCorrectPair(String input) {
        int startPair = 0;
        int lastPair = 0;
        int flag = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                if (i + 4 >= input.length()) {
                    return false;
                }
                if (!isCorrectLastElement(input, i + 3)) {
                    return false;
                }
                startPair++;
                flag = 1;
                i++;
            }
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                if (flag == 0) {
                    return false;
                }
                lastPair++;
                flag = 0;
                i++;
            }
        }
        if ((startPair == lastPair) && startPair != 0) {
            return true;
        }
        return false;
    }

    private static boolean isCorrectLastElement(String input, int idx) {
        if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
            return true;
        }
        return false;
    }
}
