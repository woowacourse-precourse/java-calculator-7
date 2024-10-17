package calculator.view;

public class OutputView {

    private static final String OUTPUT_PREFIX = "결과 : ";

    public void printResult(int result) {
        System.out.println(OUTPUT_PREFIX + result);
    }
}
