package calculator;

public class Validator {
    private static char delimiter;

    public static void isValidCustomDelimiter() {
        String input = Application.getInput();
        if (Application.getSubstringOfInput(0, 2).equals("//") == false ||
                Application.getSubstringOfInput(3, 5).equals("\\n") == false) {
            throw new IllegalArgumentException(Constants.INVALID_FORMAT);
        }
    }

    public static void isValidDefaultCharacter(char character) {
       if (character != ',' && character != ':' &&
           Character.isDigit(character) == false) {
           throw new IllegalArgumentException(Constants.INVALID_FORMAT);
       }
    }

    public static int isValidCharacterPosition() {
        char[] charString = Application.getInputToCharArray();
        int curIdx = Calculator.getCurIdx();

        while (curIdx < Application.getInputSize() && charString[curIdx] != delimiter) {
            if (Character.isDigit(charString[curIdx]) == false) {
                throw new IllegalArgumentException(Constants.INVALID_FORMAT);
            }
            curIdx++;
        }
        return curIdx;
    }

    public static void setDelimiter(char newDelimiter) { delimiter = newDelimiter; }

    public static char getDelimiter() { return delimiter; }
}