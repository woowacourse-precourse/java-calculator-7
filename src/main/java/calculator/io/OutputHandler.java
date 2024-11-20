package calculator.io;

public class OutputHandler {
    public static void printResult(String result) {
        Printer.printMessageWithFormat("결과 : %s", makeResultLikeInteger(result));
    }

    private static String makeResultLikeInteger(String result) {
        return result.replaceAll("\\.0$", "");
    }
}
