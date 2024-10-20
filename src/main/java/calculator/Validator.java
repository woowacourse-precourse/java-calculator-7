package calculator;

public class Validator {
    private static char delimiter;

    public static void isValidCustomDelimiter() {
        String input = Application.getInput();
        if (input.substring(0, 2).equals("//") == false ||
                input.substring(3, 5).equals("\\n") == false)
            throw new IllegalArgumentException("Format is invalid.");

    }

    public static void isValidDefaultCharacter(char character) {
       if (character != '-' && character != '+' &&
           character != ',' && character != ':' &&
           Character.isDigit(character) == false)
           throw new IllegalArgumentException("Format is invalid.");
    }

//    public static boolean isValidCustomDelimiterString() {
//        String input = Application.getInput();
//            throw new IllegalArgumentException("Format is invalid.");
//        return true;
//    }

    public static int isValidCharacterPosition() {
        String input = Application.getInput();
        char[] charString = input.toCharArray();
        int curIdx = Calculator.getCurIdx();
        boolean signFlag = false;

        if (charString[curIdx] == '+' || charString[curIdx] == '-')
            curIdx++;
        while (curIdx < input.length() && charString[curIdx] != delimiter) {
            if (Character.isDigit(charString[curIdx]) == false)
                throw new IllegalArgumentException("Format is invalid.");
            curIdx++;
        }
        return curIdx;
    }


    public static void setDelimiter(char newDelimiter) {
        delimiter = newDelimiter;
        System.out.println("delemiter: " + delimiter);
    }

    public static char getDelimiter() { return delimiter; }
}