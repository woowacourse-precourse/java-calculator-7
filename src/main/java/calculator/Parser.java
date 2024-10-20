package calculator;

public class Parser {
    public static void parse() {
        String input = Application.getInput();
        handleByType();
    }

    public static void handleByType() {
        String input = Application.getInput();
        if (checkDelimiterType(input.charAt(0)) == true) {
            handleDefaultDelimiter();
        }
        else {
            handleCustomDelimiter();
        }
    }

    public static void handleDefaultDelimiter() {
        String input = Application.getInput();
        char[] charString = input.toCharArray();

        for (int idx = 0; idx < input.length(); idx++) {
            Validator.isValidDefaultCharacter(charString[idx]);
            if (charString[idx] == ':')
                charString[idx] = ',';
        }

        Application.setInput(new String(charString));
        System.out.println("fixed input: " + Application.getInput());
        Validator.setDelimiter(',');
    }

    public static void handleCustomDelimiter() {
        String input = Application.getInput();
        Validator.isValidCustomDelimiter();
        extractCustomDelimiter();
    }

    public static boolean checkDelimiterType(char firstChar) {
        return (Character.isDigit(firstChar) ||
                firstChar == '+' || firstChar == '-');
    }

    public static void extractCustomDelimiter() {
        String input = Application.getInput();
        Validator.setDelimiter(input.charAt(2));
        Calculator.setCurIdx(5);
    }

    public static int parseInteger() {
        System.out.println("parseInteger");

        int curIdx = Calculator.getCurIdx();
        int nextIdx = Validator.isValidCharacterPosition();

        System.out.println("cur: " + curIdx + ", next: " + nextIdx);

        String numString = Application.getInput().substring(curIdx, nextIdx);
        System.out.println("numString: " + numString);

        Calculator.setCurIdx(nextIdx + 1);

        int num = Integer.parseInt(numString);
        System.out.println("parsed num: " + num);
        return num;
    }
}
