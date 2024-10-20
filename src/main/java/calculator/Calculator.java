package calculator;

public class Calculator {
    private static int curIdx;

    public static int calculate() {
//        System.out.println(Application.getInput().length());
//        if (Application.getInput().length() == 0)
//            return 0;
        Calculator.setCurIdx(0);
        Parser.parse();
        return iterateString();
    }

    public static int iterateString() {
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
