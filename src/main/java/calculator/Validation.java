package calculator;

public class Validation {

    public static void checkCustomSeparator(String input) {
        isCorrectCustomSeparatorForm(input);
    }

    public static void isCorrectCustomSeparatorForm(String input) {
        input = Parser.getSeparatorString(input);
        isCorrectPair(input);
    }

    public static void isCorrectInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ',' || input.charAt(i) == ':' || isNumber(input.charAt(i)))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isCorrectPair(String input) {
        int startPair = 0;
        int lastPair = 0;
        int flag = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                if (i + 4 >= input.length() || !isCorrectLastElement(input, i + 3)) {
                    throw new IllegalArgumentException();
                }
                startPair++;
                flag = 1;
                i++;
            }
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                if (flag == 0) {
                    throw new IllegalArgumentException();
                }
                lastPair++;
                flag = 0;
                i++;
            }
        }
        if ((startPair == lastPair) && startPair == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCorrectLastElement(String input, int idx) {
        if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
            return true;
        }
        return false;
    }


    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
