package calculator.view;

public class OutputView {

    private static final String OUTPUT_STRING = "결과 : %d";

    public void printResult(int result) {
        System.out.printf(OUTPUT_STRING, result);
    }
}
