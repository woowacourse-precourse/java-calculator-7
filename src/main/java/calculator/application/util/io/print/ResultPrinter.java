package calculator.application.util.io.print;

public final class ResultPrinter {

    private static final String RESULT_FORMAT = "결과 : %d";

    private ResultPrinter() {}

    public static void printResult(long result) {
        System.out.printf(RESULT_FORMAT, result);
    }
}
