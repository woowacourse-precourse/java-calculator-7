package calculator;

public class Parser {
    public static void parse() {
        if (checkDelimiterType() == true) {
            handleDefaultDelimiter();
        } else {
            handleCustomDelimiter();
        }
    }

    public static int parseInteger() {
        int curIdx = Calculator.getCurIdx();
        int nextIdx = Validator.isValidCharacterPosition();

        String numString = Application.getSubstringOfInput(curIdx, nextIdx);
        Calculator.setCurIdx(nextIdx + 1);

        return Integer.parseInt(numString);
    }

    private static void handleDefaultDelimiter() {
        char[] charArray = Application.getInputToCharArray();

        for (int idx = 0; idx < Application.getInputSize(); idx++) {
            Validator.isValidDefaultCharacter(charArray[idx]);
            if (charArray[idx] == ':') {
                charArray[idx] = ',';
            }
        }

        Application.setInputWithCharArray(charArray);
        Validator.setDelimiter(',');
    }

    private static void handleCustomDelimiter() {
        Validator.isValidCustomDelimiter();
        extractCustomDelimiter();
    }

    private static boolean checkDelimiterType() {
        char c = Application.getCharInInput(0);
        return (Character.isDigit(c) || c == '+' || c == '-');
    }

    private static void extractCustomDelimiter() {
        Validator.setDelimiter(Application.getCharInInput(2));
        Calculator.setCurIdx(5);
    }
}
