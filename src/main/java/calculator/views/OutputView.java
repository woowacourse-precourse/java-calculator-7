package calculator.views;

public class OutputView {
    private static final String OUTPUT_MSG = "결과 : ";
    public static void printResult(int result) {
        System.out.println(OUTPUT_MSG + result);
    }
}
