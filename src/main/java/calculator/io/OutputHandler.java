package calculator.io;

public class OutputHandler {
    public static void printResult(String result) {
        Printer.printMessageWithFormat("결과 : %d", result);
    }

    public static void printIntro() {
        Printer.printMessage("덧셈할 문자열을 입력해 주세요.");
        makeNewLine();
    }

    public static void makeNewLine() {
        System.out.println();
    }
}
