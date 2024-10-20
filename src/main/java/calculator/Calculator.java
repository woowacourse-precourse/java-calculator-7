package calculator;

public class Calculator {
    private static int curIdx;

    public static int calculate() {
        Calculator.setCurIdx(0);
        Parser.parse();
        return iterateString();
    }

    private static int iterateString() {
        String input = Application.getInput();
        int size = input.length();
        int res = 0;

        while (curIdx < size) {
            res += Parser.parseInteger();
        }

        return res;
    }

    public static void setCurIdx(int newIdx) { curIdx = newIdx; }

    public static int getCurIdx() { return curIdx; }
}
