package calculator;

public class Parser {
    public static void parse() {
        handleByType();
    }

    public static void handleByType() {
        if (checkDelimiterType() == true) {
            handleDefaultDelimiter();
        }
        else {
            handleCustomDelimiter();
        }
    }

    public static void handleDefaultDelimiter() {
        char[] charArray = Application.getInputToCharArray();

        for (int idx = 0; idx < Application.getInputSize(); idx++) {
            Validator.isValidDefaultCharacter(charArray[idx]);
            if (charArray[idx] == ':')
                charArray[idx] = ',';
        }

        Application.setInputWithCharArray(charArray);
        System.out.println("fixed input: " + Application.getInput());
        Validator.setDelimiter(',');
    }

    public static void handleCustomDelimiter() {
        Validator.isValidCustomDelimiter();
        extractCustomDelimiter();
    }

    public static boolean checkDelimiterType() {
        char c = Application.getCharInInput(0);
        return (Character.isDigit(c) || c == '+' || c == '-');
    }

    public static void extractCustomDelimiter() {
        Validator.setDelimiter(Application.getCharInInput(2));
        Calculator.setCurIdx(5);
    }

    public static int parseInteger() {
        int curIdx = Calculator.getCurIdx();
        int nextIdx = Validator.isValidCharacterPosition();

        System.out.println("cur: " + curIdx + ", next: " + nextIdx);

        String numString = Application.getSubstringOfInput(curIdx, nextIdx);
        System.out.println("numString: " + numString);

        Calculator.setCurIdx(nextIdx + 1);

        return Integer.parseInt(numString);
    }
}
